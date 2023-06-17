package com.example.digitallibrary.api.controller;

import com.example.digitallibrary.api.DTO.request.TrabalhoFilter;
import com.example.digitallibrary.api.DTO.request.TrabalhoRequest;
import com.example.digitallibrary.api.DTO.response.TrabalhoAcademicoResponse;
import com.example.digitallibrary.core.exceptions.DomainException;
import com.example.digitallibrary.domain.model.enums.Area;
import com.example.digitallibrary.domain.service.TrabalhoAcademicoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Tag(name = "digital-library Endpoint") //LOCAL DE ACESSO - localhost:8000/swagger-ui.html
@RestController
@RequestMapping(value = "digital-library")
@CrossOrigin(origins = "http://localhost:3000")
public class DigitalLibraryController {

    private final TrabalhoAcademicoService trabalhoAcademicoService;
    private final ObjectMapper objectMapper;


    public DigitalLibraryController(TrabalhoAcademicoService trabalhoAcademicoService, ObjectMapper objectMapper) {
        this.trabalhoAcademicoService = trabalhoAcademicoService;
        this.objectMapper = objectMapper;

    }

    @Operation(summary = "Salva um novo Trabalho Academico")
    @PostMapping(value = "/save", consumes = "multipart/form-data")
    public ResponseEntity<?> salvarTeste(@RequestParam("file") MultipartFile file,
                                         @RequestParam("trabalhoRequest") String trabalhoRequestJson){

        try{
            System.out.println("*******REQ RCB *************");
            TrabalhoRequest trabalhoRequest = objectMapper.readValue(trabalhoRequestJson, TrabalhoRequest.class);
            return new ResponseEntity<>(
                    trabalhoAcademicoService.salvar(trabalhoRequest, file),
                    HttpStatus.CREATED
            );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }



    /** Buscar pelo identificador*/
    @Operation(summary = "Busca um trabalho academico pelo identificador do Arquivo")
    @GetMapping(value = "/identificador/{identificador}")
    public ResponseEntity<?> buscarPorIdentificador(@PathVariable String identificador){

        try{
            return new ResponseEntity<>(trabalhoAcademicoService.buscarPeloIdentificador(identificador),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    /** Buscar por ano*/
    @Operation(summary = "Busca um trabalho academico por ano")
    @GetMapping(value = "/ano/{ano}")
    public ResponseEntity<?> buscarPorAno(@PathVariable/*("ano")*/ int ano){

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
    @GetMapping(value = "/area{area}")
    public ResponseEntity<?> buscarPorArea(/*@PathVariable*/@RequestParam(value = "area") String area){
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
    @Operation(summary = "Busca os trabalhos relacionados com o filtro informado")
    @PutMapping(value = "/filter")
    public ResponseEntity<?> buscarFiltro(@RequestBody @Valid TrabalhoFilter filter ){
        try{

            System.out.println("TEXTO BUSCADO: " + filter.getTextoInformado());
            return new ResponseEntity<>(trabalhoAcademicoService.buscarFiltro(filter),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }



    /** ONLY FOR TESTE REQUEST*/

    /** Realiza o Download do arquivo*/
    @GetMapping(value = "/download/{identificador}")
    public ResponseEntity<?>  download(@PathVariable("identificador") String identificador){
        System.out.println("Acessou o endpoint");
        return null;
    }

    @PostMapping(value = "/endpointteste")
    public ResponseEntity<?> salvarTESTE(@RequestParam("file") MultipartFile file,
                                         @RequestParam(value = "codAluno") String codAluno,
                                         @RequestParam(value = "codProfessor") String codProfessor){
        TrabalhoRequest trabalhoRequest = new TrabalhoRequest("Ocupação dos Manguezais Ludovicenses", "Biologia, Ecossistema, Saude, Animal, Vegetal, Natureza",
                "O manguezal é considerado um ecossistema costeiro de transição entre os ambientes terrestre e marinho. Característico de regiões tropicais e subtropicais, está sujeito ao regime das marés, dominado por espécies vegetais típicas, às quais se associam a outros componentes vegetais e animais.",
                "manguezal, bioma, berçário, mangue", 2013, codAluno, codProfessor);

        try{
            if (file.isEmpty()) {
                throw new DomainException("Erro: arquivo vazio!");
            }


            return new ResponseEntity<>(
                    trabalhoAcademicoService.salvar(trabalhoRequest, file),
                    HttpStatus.CREATED
            );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/endpointtest/front")
    public ResponseEntity<?> salvarTESTEFront(@RequestBody TrabalhoRequest trabalhoRequest){
        System.out.println(trabalhoRequest.toString());
        System.out.println("PARAMETROS RECEBIDOS: titulo " + trabalhoRequest.getTitulo() +
                " | area: " + trabalhoRequest.getArea()  + " | area TO ENUM:" + Area.toEnumByReference(trabalhoRequest.getArea())+
                " | resumo: " + trabalhoRequest.getAnoPublicacao()
        );


        try{
            return new ResponseEntity<>(
                    new TrabalhoAcademicoResponse("1234dfwkjjhng"),
                    HttpStatus.CREATED
            );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

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
}
