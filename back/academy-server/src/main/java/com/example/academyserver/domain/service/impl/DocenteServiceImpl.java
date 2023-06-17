package com.example.academyserver.domain.service.impl;

import com.example.academyserver.domain.exceptions.DocenteNaoEncontradoException;
import com.example.academyserver.domain.model.Docente;
import com.example.academyserver.domain.model.enums.Departamento;
import com.example.academyserver.domain.repository.DocenteRepository;
import com.example.academyserver.domain.service.DocenteService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteServiceImpl(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    @Override
    public Docente findById(Long idDocente) {

        return docenteRepository.findById(idDocente)
                .orElseThrow(() -> new DocenteNaoEncontradoException(idDocente));
    }

    @Override
    public Docente findByCodigo(String codProf) {
        return docenteRepository.findByCodigo(codProf)
                .orElseThrow(() -> new DocenteNaoEncontradoException(codProf));
    }

    @Override
    public Docente findByName(String nome) {
        return docenteRepository.findByNome(nome)
                .orElseThrow(() -> new DocenteNaoEncontradoException(nome));
    }

    @Override
    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    @Override
    public Docente save(Docente docente) {
        docente.setCodigo(gerarCodigo(docente.getDepartamento()));

        return docenteRepository.save(docente);
    }

    private String gerarCodigo(Departamento depto){
        LocalDateTime sufix = LocalDateTime.now();
        String builder = sufix.getYear()+depto.toString()+sufix.getMinute()+sufix.getSecond();
        return builder;
    }
}
