package com.example.digitallibrary.core.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "academy-server")
public interface ParticipanteProxy {

    @GetMapping(value = "academy-server")
    void buscarAluno(@RequestParam(value = "codigo") String codigo);

    /**TODO:
     * Buscar professor por codigo
     * buscra aluno por código
     * */
}
