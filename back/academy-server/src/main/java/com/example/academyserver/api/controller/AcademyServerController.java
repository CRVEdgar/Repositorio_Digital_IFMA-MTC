package com.example.academyserver.api.controller;

import com.example.academyserver.domain.model.Discente;
import com.example.academyserver.domain.model.Docente;
import com.example.academyserver.domain.service.DiscenteService;
import com.example.academyserver.domain.service.DocenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "academy-server Endpoint") //LOCAL DE ACESSO - localhost:8100/swagger-ui.html
@RestController
@RequestMapping(value = "academy-server")
@CrossOrigin(origins = "http://localhost:3000")
public class AcademyServerController {

    private final DiscenteService discenteService;
    private final DocenteService docenteService;

    public AcademyServerController(DiscenteService discenteService, DocenteService docenteService) {
        this.discenteService = discenteService;
        this.docenteService = docenteService;
    }

    @Operation(summary = "busca um Discente pelo codigo")
    @GetMapping(value = "/aluno/codigo{codigoAluno}")
    @ResponseStatus(HttpStatus.OK)
    public Discente buscarAlunoCod(@RequestParam(value = "codigoAluno") String codigoAluno){

       return discenteService.findByCodigo(codigoAluno);
    }

    @GetMapping(value = "/aluno/codigoAluno/{codigoAluno}")
    @ResponseStatus(HttpStatus.OK)
    public Discente buscarAlunoCodPath(@PathVariable String codigoAluno){
        System.out.println("Buscando aluno de codigo: " + codigoAluno);
        return discenteService.findByCodigo(codigoAluno);
    }

    @Operation(summary = "busca um Discente pelo nome")
    @GetMapping(value = "/aluno/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Discente buscarAlunoNome(@PathVariable("nome") String nome){

        return discenteService.findByName(nome);
    }

    @Operation(summary = "retorna o registo de todos Discentes")
    @GetMapping(value = "/aluno/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Discente> buscarTodosAlunos(){
        return discenteService.findAll();
    }

    @Operation(summary = "salva um novo registro de Discente")
    @PostMapping(value = "/aluno")
    @ResponseStatus(HttpStatus.CREATED)
    public Discente salvarAluno(@RequestBody Discente aluno){
        return discenteService.save(aluno);
    }

    /** docente endpoint*/
    @Operation(summary = "busca um Docente pelo codigo")
    @GetMapping(value = "/professor/codigo{codigoProfessor}")
    @ResponseStatus(HttpStatus.OK)
    public Docente buscarProfessorCod(@RequestParam(value = "codigoProfessor") String codigoProfessor){

        return docenteService.findByCodigo(codigoProfessor);
    }

    @Operation(summary = "busca um Docente pelo nome")
    @GetMapping(value = "/professor/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Docente buscarProfessorNome(@PathVariable("nome") String nome){

        return docenteService.findByName(nome);
    }

    @Operation(summary = "retorna o registo de todos Docentes")
    @GetMapping(value = "/professor/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Docente> buscarTodosProfessores(){
        return docenteService.findAll();
    }

    @Operation(summary = "salva um novo registro de Docente")
    @PostMapping(value = "/professor")
    @ResponseStatus(HttpStatus.CREATED)
    public Docente salvarProfessor(@RequestBody Docente professor){
        return docenteService.save(professor);
    }

}
