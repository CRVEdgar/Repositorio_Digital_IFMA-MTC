package com.example.digitallibrary.api.controller;

import com.example.digitallibrary.api.DTO.response.TrabalhoAcademicoResponse;
import com.example.digitallibrary.core.proxy.FileServerProxy;
import com.example.digitallibrary.core.proxy.ParticipanteProxy;
import com.example.digitallibrary.domain.model.TrabalhoAcademico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "digital-library Endpoint") //LOCAL DE ACESSO - localhost:8000/swagger-ui.html
@RestController
@RequestMapping(value = "digital-library")
public class DigitalLibraryController {

    private final FileServerProxy fileServerProxy;
    private final ParticipanteProxy participanteProxy;

    public DigitalLibraryController(FileServerProxy fileServerProxy, ParticipanteProxy participanteProxy) {
        this.fileServerProxy = fileServerProxy;
        this.participanteProxy = participanteProxy;
    }


    @Operation(summary = "busca um trabalho academico")
    @GetMapping(value = "/{id}/{currency}")
    public TrabalhoAcademicoResponse findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency){
        return null;
    }

}
