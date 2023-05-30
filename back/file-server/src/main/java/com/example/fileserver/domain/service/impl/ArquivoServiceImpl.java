package com.example.fileserver.domain.service.impl;

import com.example.fileserver.core.exceptions.ArquivoNaoEncontradoException;
import com.example.fileserver.core.exceptions.ServiceException;
import com.example.fileserver.core.util.FileUtils;
import com.example.fileserver.domain.model.Arquivo;
import com.example.fileserver.domain.repository.ArquivoRepository;
import com.example.fileserver.domain.service.ArquivoService;
import com.example.fileserver.domain.service.StoreService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ArquivoServiceImpl implements ArquivoService {

    private final ArquivoRepository arquivoRepository;
    private final StoreService storeService;

    public ArquivoServiceImpl(ArquivoRepository arquivoRepository, StoreService storeService) {
        this.arquivoRepository = arquivoRepository;
        this.storeService = storeService;
    }

    @Override
    public Arquivo findByIdentificador(String identificador) {
        return arquivoRepository.findByIdentificador(identificador)
                .orElseThrow(() -> new ArquivoNaoEncontradoException(identificador));
    }

    @Override
    public Arquivo findByTitulo(String titulo) {
        return arquivoRepository.findByTitulo(titulo)
                .orElseThrow(() -> new ArquivoNaoEncontradoException(titulo));
    }

    @Override
    public Arquivo findByfileName(String filename) {
        return arquivoRepository.findByFileName(filename)
                .orElseThrow(() -> new ArquivoNaoEncontradoException(filename));
    }

    @Override
    public Arquivo findByHashMd5(String hash) {
        return arquivoRepository.findByHashMD5(hash)
                .orElseThrow(() -> new ArquivoNaoEncontradoException(hash));
    }

    @Override
    public List<Arquivo> findAll() {
        return arquivoRepository.findAll();
    }

    @Override
    public Arquivo save(MultipartFile file, String identificador, String titulo) {

        Arquivo arquivoSalvo = new Arquivo();

        arquivoSalvo.setIdentificador(identificador);
        arquivoSalvo.setTitulo(titulo);

        try {
            arquivoSalvo.setHashMD5(FileUtils.getFileMD5(file.getInputStream()));
        } catch (IOException e) {
            throw new ServiceException(e.getMessage());
        }

        /** Salva o arquivo no FileSystem */
        arquivoSalvo.setFileName(storeService.store(file));

        return arquivoRepository.save(arquivoSalvo);
    }

    @Override
    public Resource loadAsResource(String identificador) throws ServiceException {

        Arquivo arquivo = arquivoRepository.findByIdentificador(identificador).get();

        if(arquivo==null || arquivo.getFileName().isEmpty()){
            throw new ServiceException("ARQUIVO NAO ENCONTRADO - DADOS DE SOLICITAÇÃO INVALIDO");
        }

        try{
            System.out.println("RESOUCE: " + new UrlResource( storeService.load(arquivo.getFileName()).toUri() ).getURL() );
            return new UrlResource(
                    storeService.load(arquivo.getFileName()).toUri()
            );
        }catch (Exception e){
            throw new ServiceException("NÃO FOI POSSÍVEL LOCALIZAR O ARQUIVO");
        }

    }


}
