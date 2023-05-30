package com.example.academyserver.domain.service;

import com.example.academyserver.domain.model.Docente;
import org.springframework.stereotype.Service;

import java.util.List;
public interface DocenteService {

    Docente findById(Long id);
    Docente findByCodigo(String id);
    Docente findByName(String nome);
    List<Docente> findAll();
    Docente save(Docente docente);

}
