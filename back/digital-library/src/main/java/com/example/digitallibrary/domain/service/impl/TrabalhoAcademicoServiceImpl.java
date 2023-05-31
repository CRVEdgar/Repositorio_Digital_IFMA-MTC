package com.example.digitallibrary.domain.service.impl;

import com.example.digitallibrary.api.DTO.request.TrabalhoRequest;
import com.example.digitallibrary.api.DTO.response.TrabalhoAcademicoResponse;
import com.example.digitallibrary.core.exceptions.DomainException;
import com.example.digitallibrary.core.util.FileUtil;
import com.example.digitallibrary.domain.model.Arquivo;
import com.example.digitallibrary.domain.model.Membro;
import com.example.digitallibrary.domain.model.TrabalhoAcademico;
import com.example.digitallibrary.domain.service.ArquivoService;
import com.example.digitallibrary.domain.service.MembroService;
import com.example.digitallibrary.domain.service.TrabalhoAcademicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TrabalhoAcademicoServiceImpl implements TrabalhoAcademicoService {

    private final ArquivoService arquivoService;
    private final MembroService membroService;


    public TrabalhoAcademicoServiceImpl(ArquivoService arquivoService, MembroService membroService) {
        this.arquivoService = arquivoService;
        this.membroService = membroService;
    }

    @Override
    public TrabalhoAcademicoResponse salvar(TrabalhoRequest trabalhoRequest, MultipartFile file) throws DomainException{

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
        /** Buscar pelo Orintador*/
        Membro orientador = membroService.buscarProfessor(trabalhoRequest.getCodOrientador());

        /** Enviando o arquivo para o servidor de arquivos*/
        Arquivo arquivoSalvo = arquivoService.enviar(file, autor.getCodigo(), orientador.getCodigo(), trabalhoRequest.getTitulo() );

        return null;
    }
}
