package com.example.digitallibrary.core.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "academy-server")
@Component
public interface ParticipanteProxy {

//    @PostMapping(value = "academy-server")
//    void criarAutomaticCard(@RequestBody List<Participantes> participantesList);

    /**TODO:
     * Buscar professor por codigo
     * buscra aluno por código
     * */
}
