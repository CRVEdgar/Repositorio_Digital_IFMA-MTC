package com.example.digitallibrary.domain.service.impl;

import com.example.digitallibrary.api.DTO.request.TrabalhoFilter;
import com.example.digitallibrary.api.DTO.request.TrabalhoRequest;
import com.example.digitallibrary.api.DTO.response.TrabalhoAcademicoResponse;
import com.example.digitallibrary.core.exceptions.DomainException;
import com.example.digitallibrary.core.util.FileUtil;
import com.example.digitallibrary.domain.model.Arquivo;
import com.example.digitallibrary.domain.model.Membro;
import com.example.digitallibrary.domain.model.TrabalhoAcademico;
import com.example.digitallibrary.domain.model.enums.Area;
import com.example.digitallibrary.domain.model.enums.VinculoType;
import com.example.digitallibrary.domain.repository.TrabalhoAcademicoRepository;
import com.example.digitallibrary.domain.service.ArquivoService;
import com.example.digitallibrary.domain.service.MembroService;
import com.example.digitallibrary.domain.service.TrabalhoAcademicoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class TrabalhoAcademicoServiceImpl implements TrabalhoAcademicoService {

    private final ArquivoService arquivoService;
    private final MembroService membroService;
    private final TrabalhoAcademicoRepository repository;

    public TrabalhoAcademicoServiceImpl(ArquivoService arquivoService, MembroService membroService, TrabalhoAcademicoRepository repository) {
        this.arquivoService = arquivoService;
        this.membroService = membroService;
        this.repository = repository;
    }

    @Override
    public TrabalhoAcademicoResponse salvar(TrabalhoRequest trabalhoRequest, MultipartFile file) throws DomainException{
        TrabalhoAcademico trabalhoAcademico = new TrabalhoAcademico();
        Arquivo arquivoSalvo = new Arquivo();

        if(!FileUtil.existe(file)){
            throw new DomainException("ARQUIVO NAO ENVIADO");
        }

        if(!FileUtil.tamanhoPermitido(file)){
            throw new DomainException("TAMANHO DO ARQUIVO EXCEDE O LIMITE PERMITIDO");
        }
        if(!FileUtil.extensaoValida(file)){
            throw new DomainException("FORMATO DE ARQUIVO INVÁLIDO");
        }

        /** Buscar pelo autor*/
        Membro autor = membroService.buscarAluno(trabalhoRequest.getCodAutor());
        if(autor!=null){
            System.out.println("LOCALIZOU O ALUNO: " + autor.getNome());
        }
        /** Buscar pelo Orintador*/
        Membro orientador = membroService.buscarProfessor(trabalhoRequest.getCodOrientador());
        if(orientador!=null){
            System.out.println("LOCALIZOU O PROFESSOR: " + orientador.getNome());
        }


        /** Enviando o arquivo para o servidor de arquivos*/
        try{
            arquivoSalvo = arquivoService.enviar(file, autor.getCodigo(), orientador.getCodigo(), trabalhoRequest.getTitulo() );

        }catch (Exception e){
            throw new DomainException("NÃO FOI POSSÍVEL SALVAR ARQUIVO NA BASE DE DADOS - TENTE NOVAMENTE EM INSTANTES");
        }

        trabalhoAcademico.setTitulo(trabalhoRequest.getTitulo());
        trabalhoAcademico.setResumo(trabalhoRequest.getResumo());
        trabalhoAcademico.setPalavrasChave(trabalhoRequest.getPalavrasChave());
        trabalhoAcademico.setAno(trabalhoRequest.getAnoPublicacao());
        trabalhoAcademico.setAutor(autor.getNome());
        trabalhoAcademico.setOrientador(orientador.getNome());
//        trabalhoAcademico.setArea( Area.toEnum(trabalhoRequest.getArea()) );
        trabalhoAcademico.setArea( Area.toEnumByReference(trabalhoRequest.getArea()) );
        trabalhoAcademico.setArquivo(arquivoSalvo);
        Membro autorMembro = new Membro(autor.getCodigo(), autor.getNome(), VinculoType.ALUNO);
        Membro orientadorMembro = new Membro(orientador.getCodigo(), orientador.getNome(), VinculoType.PROFESSOR);
        trabalhoAcademico.setMembros(Set.of(autorMembro, orientadorMembro));


        /** Salvando as informações do Arquivo na base*/
        arquivoService.save(arquivoSalvo);

        /** Salvando as informações do Trabalho na base*/
        repository.save(trabalhoAcademico);

        return toDTO(trabalhoAcademico);
    }

    @Override
    public List<TrabalhoAcademicoResponse> buscarPorAno(int ano) throws DomainException{
        List<TrabalhoAcademicoResponse> listaTrabalhos = new ArrayList<>();

        List<TrabalhoAcademico> trabalhosBD = repository.findByAno(ano);

        for (TrabalhoAcademico trabalhoToDTO : trabalhosBD){
            TrabalhoAcademicoResponse response = toDTO(trabalhoToDTO);

            listaTrabalhos.add(response);
        }

        return listaTrabalhos;
    }

    @Override
    public TrabalhoAcademicoResponse buscarPeloIdentificador(String identificador) throws DomainException {

        TrabalhoAcademico trabalhosBD = repository.findByArquivo_Identificador(identificador);

        TrabalhoAcademicoResponse response = toDTO(trabalhosBD);

        return response;
    }

    @Override
    public List<TrabalhoAcademicoResponse> buscarPorArea(String area) throws DomainException {
        List<TrabalhoAcademicoResponse> listaTrabalhos = new ArrayList<>();

//        Area areaEnum = Area.toEnum(area);
        Area areaEnum = Area.toEnumByReference(area);

        List<TrabalhoAcademico> trabalhosBD = repository.findByArea( areaEnum );

        for (TrabalhoAcademico trabalhoToDTO : trabalhosBD){
            TrabalhoAcademicoResponse response = toDTO(trabalhoToDTO);

            listaTrabalhos.add(response);
        }

        return listaTrabalhos;
    }

    @Override
    public List<TrabalhoAcademicoResponse> buscarTodos() throws DomainException {
        List<TrabalhoAcademicoResponse> listaTrabalhos = new ArrayList<>();

        List<TrabalhoAcademico> trabalhosBD = repository.findAll( );

        for (TrabalhoAcademico trabalhoToDTO : trabalhosBD){
            TrabalhoAcademicoResponse response = toDTO(trabalhoToDTO);

            listaTrabalhos.add(response);
        }

        return listaTrabalhos;
    }

    @Override
    public List<TrabalhoAcademicoResponse> buscarFiltro(TrabalhoFilter filter) throws DomainException {
        List<TrabalhoAcademicoResponse> listaTrabalhos = new ArrayList<>();

        List<TrabalhoAcademico> trabalhosFiltrados = repository.especificationTextoDesejado(filter.getTextoInformado());

        for (TrabalhoAcademico trabalhoToDTO : trabalhosFiltrados){
            TrabalhoAcademicoResponse response = toDTO(trabalhoToDTO);

            listaTrabalhos.add(response);
        }

        return listaTrabalhos;
    }

    private TrabalhoAcademicoResponse toDTO(TrabalhoAcademico trabalhoDomain){
        TrabalhoAcademicoResponse response = new TrabalhoAcademicoResponse(trabalhoDomain.getArquivo().getIdentificador())
                .andNomeAutor(trabalhoDomain.getAutor())
                .andNomeOrientador(trabalhoDomain.getOrientador())
                .andTitulo(trabalhoDomain.getTitulo())
                .andResumo(trabalhoDomain.getResumo())
                .andArea(trabalhoDomain.getArea().getArea())
                .andAno(trabalhoDomain.getAno())
                .andPalavrasChave(trabalhoDomain.getPalavrasChave())
                .thatsAll();
        return response;
    }
}
