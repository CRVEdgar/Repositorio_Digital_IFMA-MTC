package com.example.digitallibrary.domain.service;

import com.example.digitallibrary.api.DTO.request.TrabalhoFilter;
import com.example.digitallibrary.api.DTO.request.TrabalhoRequest;
import com.example.digitallibrary.api.DTO.response.TrabalhoAcademicoResponse;
import com.example.digitallibrary.core.exceptions.DomainException;
import com.example.digitallibrary.domain.model.TrabalhoAcademico;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TrabalhoAcademicoService {

    TrabalhoAcademicoResponse salvar(TrabalhoRequest trabalhoRequest, MultipartFile file) throws DomainException;

    List<TrabalhoAcademicoResponse> buscarPorAno(int ano) throws DomainException;
    TrabalhoAcademicoResponse buscarPeloIdentificador(String identificador) throws DomainException;

    List<TrabalhoAcademicoResponse> buscarPorArea(String area) throws DomainException;

    List<TrabalhoAcademicoResponse> buscarTodos() throws DomainException;

    List<TrabalhoAcademicoResponse> buscarFiltro(TrabalhoFilter filter) throws DomainException;



}
