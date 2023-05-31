package com.example.digitallibrary.domain.service.impl;

import com.example.digitallibrary.core.exceptions.DomainException;
import com.example.digitallibrary.core.proxy.FileServerProxy;
import com.example.digitallibrary.core.util.FileUtil;
import com.example.digitallibrary.domain.model.Arquivo;
import com.example.digitallibrary.domain.repository.ArquivoRepository;
import com.example.digitallibrary.domain.service.ArquivoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArquivoServiceImpl implements ArquivoService {

    private final FileServerProxy fileServerProxy;
    private final ArquivoRepository arquivoRepository;

    public ArquivoServiceImpl(FileServerProxy fileServerProxy, ArquivoRepository arquivoRepository) {
        this.fileServerProxy = fileServerProxy;
        this.arquivoRepository = arquivoRepository;
    }


    @Override
    public Arquivo enviar(MultipartFile file, String codigoAutor, String codigoorientador, String titulo) throws DomainException {

        String identificador = FileUtil.gerarIdentificador(codigoAutor, codigoorientador);


        return null;
    }
}
