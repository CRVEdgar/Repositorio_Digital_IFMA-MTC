package com.example.fileserver.domain.service;

import com.example.fileserver.core.exceptions.ServiceException;
import com.example.fileserver.domain.model.Arquivo;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArquivoService {

    Arquivo findByIdentificador(String identificador);
    Arquivo findByTitulo(String titulo);
    Arquivo findByfileName(String filename);
    Arquivo findByHashMd5(String hash);
    List<Arquivo> findAll();
    Arquivo save(MultipartFile file, String identificador, String titulo);

    Resource loadAsResource(String identificador) throws ServiceException;
}
