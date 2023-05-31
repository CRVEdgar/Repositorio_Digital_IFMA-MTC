package com.example.digitallibrary.core.proxy;

import com.example.digitallibrary.core.proxy.model.Discente;
import com.example.digitallibrary.core.proxy.model.Docente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "academy-server")
public interface ParticipanteProxy {

    @GetMapping(value = "academy-server/aluno/codigo/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public Discente buscarAlunoCod(@PathVariable("codigo") String codigoAluno);

    @GetMapping(value = "academy-server/professor/codigo/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public Docente buscarProfessorCod(@PathVariable("codigo") String codigoProfessor);

    /**TODO:
     * retornar um ResponseEntity
     * */
}
