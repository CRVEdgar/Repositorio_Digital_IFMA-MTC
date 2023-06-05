package com.example.digitallibrary.core.proxy;

import com.example.digitallibrary.core.proxy.model.Discente;
import com.example.digitallibrary.core.proxy.model.Docente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "academy-server")
public interface ParticipanteProxy {

//    @GetMapping(value = "academy-server/aluno/codigo/{codigo}")
    @GetMapping(value = "academy-server/aluno/codigo{codigoAluno}")
    @ResponseStatus(HttpStatus.OK)
    public Discente buscarAlunoCod(/*@PathVariable("codigo")*/@RequestParam(value = "codigoAluno") String codigoAluno);

//    @GetMapping(value = "academy-server/professor/codigo/{codigo}")
    @GetMapping(value = "academy-server/professor/codigo{codigoProfessor}")
    @ResponseStatus(HttpStatus.OK)
    public Docente buscarProfessorCod(/*@PathVariable("codigo")*/@RequestParam(value = "codigoProfessor") String codigoProfessor);

    /**TODO:
     * retornar um ResponseEntity
     * */
}
