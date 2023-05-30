package com.example.fileserver.domain.service;

import com.example.fileserver.core.exceptions.ServiceException;
import com.example.fileserver.domain.model.Arquivo;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StoreService {
    String store(MultipartFile arquivo);

    Path load(String filename) throws ServiceException;
}
