package com.example.fileserver.domain.service;

import com.example.fileserver.domain.model.Arquivo;
import org.springframework.web.multipart.MultipartFile;

public interface StoreService {
    String store(MultipartFile arquivo);
}
