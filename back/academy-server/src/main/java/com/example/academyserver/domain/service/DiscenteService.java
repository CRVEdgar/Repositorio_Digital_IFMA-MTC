package com.example.academyserver.domain.service;

import com.example.academyserver.domain.model.Discente;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DiscenteService {

    Discente finById(Long id);

    Discente findByCodigo(String codigo);
    Discente findByName(String nome);
    List<Discente> findAll();
    Discente save(Discente discente);


}
