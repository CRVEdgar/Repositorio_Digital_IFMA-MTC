package com.example.digitallibrary.api.controller;

import com.example.digitallibrary.api.DTO.request.TrabalhoFilter;
import com.example.digitallibrary.api.DTO.request.TrabalhoRequest;
import com.example.digitallibrary.api.DTO.response.TrabalhoAcademicoResponse;
import com.example.digitallibrary.domain.service.TrabalhoAcademicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Tag(name = "digital-library Endpoint") //LOCAL DE ACESSO - localhost:8000/swagger-ui.html
@RestController
@RequestMapping(value = "digital-library")
public class DigitalLibraryController {

    private final TrabalhoAcademicoService trabalhoAcademicoService;

    public DigitalLibraryController(TrabalhoAcademicoService trabalhoAcademicoService) {
        this.trabalhoAcademicoService = trabalhoAcademicoService;
    }

    @Operation(summary = "Salva um novo Trabalho Academico")
    @PostMapping
    public ResponseEntity<?> salvar(@RequestParam("file") MultipartFile file,
                                    @RequestBody @Valid TrabalhoRequest trabalhoRequest){

        try{
            return new ResponseEntity<>(
                    trabalhoAcademicoService.salvar(trabalhoRequest, file),
                    HttpStatus.CREATED
            );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    /** Buscar por ano*/
    @Operation(summary = "Busca um trabalho academico por ano")
    @GetMapping(value = "/ano/{ano}")
    public ResponseEntity<?> buscarPorAno(@PathVariable("ano") int ano){
        //TODO: retorna uma lista
        return null;
    }

    /** Buscar por area*/
    @Operation(summary = "Busca um trabalho academico por area")
    @GetMapping(value = "/area/{currency}")
    public ResponseEntity<?> buscarPorArea(@PathVariable("id") Long id, @PathVariable("currency") String currency){
        //TODO: retorna uma lista
        return null;
    }

    /** Buscar todos*/
    @Operation(summary = "Busca todos os trabalhos existentes na base")
    @GetMapping(value = "/all")
    public ResponseEntity<?> buscarTodos(){
        //TODO: retorna uma lista
        return null;
    }

    /** Buscar por Filtro*/
    @Operation(summary = "Busca todos os trabalhos existentes na base")
    @GetMapping(value = "/filter")
    public ResponseEntity<?> buscarFiltro(@RequestBody @Valid TrabalhoFilter filter ){
        //TODO: retorna uma lista
        return null;
    }

    /** Realiza o Download do arquivo*/
    @Operation(summary = "busca um trabalho academico")
    @GetMapping(value = "/download/{identificador}")
    public ResponseEntity<?>  download(@PathVariable("id") Long id, @PathVariable("currency") String currency){

        return null;
    }
}
