package com.example.digitallibrary.domain.service;

import com.example.digitallibrary.api.DTO.request.TrabalhoRequest;
import com.example.digitallibrary.api.DTO.response.TrabalhoAcademicoResponse;
import com.example.digitallibrary.core.exceptions.DomainException;
import com.example.digitallibrary.domain.model.TrabalhoAcademico;
import org.springframework.web.multipart.MultipartFile;

public interface TrabalhoAcademicoService {

    TrabalhoAcademicoResponse salvar(TrabalhoRequest trabalhoRequest, MultipartFile file) throws DomainException;
}
