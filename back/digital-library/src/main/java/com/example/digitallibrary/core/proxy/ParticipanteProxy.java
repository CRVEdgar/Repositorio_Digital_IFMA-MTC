package com.example.digitallibrary.core.proxy;

import com.example.digitallibrary.core.proxy.model.Participantes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "academy-server")
public interface ParticipanteProxy {

    @PostMapping(value = "trello-service") //TODO sem barra
    void criarAutomaticCard(@RequestBody List<Participantes> participantesList);
}
