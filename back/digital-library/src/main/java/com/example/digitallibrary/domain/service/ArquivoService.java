package com.example.digitallibrary.domain.service;

import com.example.digitallibrary.core.exceptions.DomainException;
import com.example.digitallibrary.domain.model.Arquivo;
import org.springframework.web.multipart.MultipartFile;

public interface ArquivoService {
    Arquivo enviar(MultipartFile file, String codigoAutor, String codigoOrientador, String titulo) throws DomainException;
}
