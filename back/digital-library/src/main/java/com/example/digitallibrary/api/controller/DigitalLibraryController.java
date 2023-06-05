package com.example.digitallibrary.api.controller;

import com.example.digitallibrary.api.DTO.request.TrabalhoFilter;
import com.example.digitallibrary.api.DTO.request.TrabalhoRequest;
import com.example.digitallibrary.core.exceptions.DomainException;
import com.example.digitallibrary.domain.service.TrabalhoAcademicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Tag(name = "digital-library Endpoint") //LOCAL DE ACESSO - localhost:8000/swagger-ui.html
@RestController
@RequestMapping(value = "digital-library")
public class DigitalLibraryController {

    private final TrabalhoAcademicoService trabalhoAcademicoService;

    public DigitalLibraryController(TrabalhoAcademicoService trabalhoAcademicoService) {
        this.trabalhoAcademicoService = trabalhoAcademicoService;
    }

    @PostMapping(value = "/endpointteste")
    public ResponseEntity<?> salvarTESTE(@RequestParam("file") MultipartFile file,
                                         @RequestParam(value = "codAluno") String codAluno,
                                         @RequestParam(value = "codProfessor") String codProfessor){
        TrabalhoRequest trabalhoRequest = new TrabalhoRequest("Ocupação dos Manguezais Ludovicenses", "Biologia, Ecossistema, Saude, Animal, Vegetal, Natureza",
                "O manguezal é considerado um ecossistema costeiro de transição entre os ambientes terrestre e marinho. Característico de regiões tropicais e subtropicais, está sujeito ao regime das marés, dominado por espécies vegetais típicas, às quais se associam a outros componentes vegetais e animais.",
                "manguezal, bioma, berçário, mangue", 2013, codAluno, codProfessor);
//        TrabalhoRequest(String titulo, String area, String resumo, String palavrasChave, int anoPublicacao, String codAutor, String codOrientador)

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
