package com.example.digitallibrary.api.controller;

import com.example.digitallibrary.api.DTO.request.TrabalhoFilter;
import com.example.digitallibrary.api.DTO.request.TrabalhoRequest;
import com.example.digitallibrary.api.DTO.response.TrabalhoAcademicoResponse;
import com.example.digitallibrary.domain.model.enums.Area;
import com.example.digitallibrary.domain.service.TrabalhoAcademicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<?> buscarPorAno(@PathVariable/*("ano")*/ int ano){
//        System.out.println("RECEBEU A REQUISIÇÃO");
//        List<TrabalhoAcademicoResponse> lista = new ArrayList<>();
//
//        TrabalhoAcademicoResponse t1 = new TrabalhoAcademicoResponse("123456")
//                .andAno(2022)
//                .andArea(Area.MATEMATICA.getArea())
//                .andTitulo("TITULO TRBALHO 1")
//                .andResumo(" is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ")
//                .thatsAll();
//
//        TrabalhoAcademicoResponse t2 = new TrabalhoAcademicoResponse("123456")
//                .andAno(2023)
//                .andArea(Area.COMPUTAÇÃO.getArea())
//                .andTitulo("segundo trabalho")
//                .andResumo(" is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ")
//                .thatsAll();
//
//        TrabalhoAcademicoResponse t3 = new TrabalhoAcademicoResponse("123456")
//                .andAno(2024)
//                .andArea(Area.EDUCACAO.getArea())
//                .andTitulo("terceiro trabalho")
//                .andResumo(" is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ")
//                .thatsAll();
//
//
//        lista.add(t1);
//        lista.add(t2);
//        lista.add(t3);
//
//        System.out.println("TAMANHO DA LISTA: " + lista.size());
//        try{
//            return new ResponseEntity<>(lista,
//                    HttpStatus.CREATED
//            );
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//        }

        try{
            return new ResponseEntity<>(trabalhoAcademicoService.buscarPorAno(ano),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    /** Buscar por area*/
    @Operation(summary = "Busca um trabalho academico por area")
    @GetMapping(value = "/area/{area}")
    public ResponseEntity<?> buscarPorArea(@PathVariable String area){
        try{
            return new ResponseEntity<>(trabalhoAcademicoService.buscarPorArea(area),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    /** Buscar todos*/
    @Operation(summary = "Busca todos os trabalhos existentes na base")
    @GetMapping(value = "/all")
    public ResponseEntity<?> buscarTodos(){
        try{
            return new ResponseEntity<>(trabalhoAcademicoService.buscarTodos(),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    /** Buscar por Filtro*/
    @Operation(summary = "Busca todos os trabalhos existentes na base")
    @GetMapping(value = "/filter")
    public ResponseEntity<?> buscarFiltro(@RequestBody @Valid TrabalhoFilter filter ){
        try{
            return new ResponseEntity<>(trabalhoAcademicoService.buscarFiltro(filter),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    /** Realiza o Download do arquivo*/
    @Operation(summary = "busca um trabalho academico")
    @GetMapping(value = "/download/{identificador}")
    public ResponseEntity<?>  download(@PathVariable("id") Long id, @PathVariable("currency") String currency){

        return null;
    }
}
