package com.example.academyserver.domain.service.impl;

import com.example.academyserver.domain.exceptions.DiscenteNaoEncontradoException;
import com.example.academyserver.domain.model.Discente;
import com.example.academyserver.domain.model.enums.Curso;
import com.example.academyserver.domain.model.enums.Departamento;
import com.example.academyserver.domain.repository.DiscenteRepository;
import com.example.academyserver.domain.service.DiscenteService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DiscenteServiceImpl implements DiscenteService {

    private final DiscenteRepository discenteRepository;

    public DiscenteServiceImpl(DiscenteRepository discenteRepository) {
        this.discenteRepository = discenteRepository;
    }

    @Override
    public Discente finById(Long idAluno) {
        return discenteRepository.findById(idAluno)
                .orElseThrow(() -> new DiscenteNaoEncontradoException(idAluno));
    }

    @Override
    public Discente findByCodigo(String codigo) {
        return discenteRepository.findByCodigo(codigo)
                .orElseThrow(() -> new DiscenteNaoEncontradoException(codigo));
    }

    @Override
    public Discente findByName(String nome) {
        return discenteRepository.findByNome(nome)
                .orElseThrow(() -> new DiscenteNaoEncontradoException(nome));
    }

    @Override
    public List<Discente> findAll() {
        return discenteRepository.findAll();
    }

    @Override
    public Discente save(Discente discente) {
        discente.setCodigo(gerarCodigo(discente.getCurso()));

        return discenteRepository.save(discente);
    }

    private String gerarCodigo(Curso curso){
        LocalDateTime sufix = LocalDateTime.now();
        String builder = sufix.getYear()+curso.toString()+sufix.getMinute()+sufix.getSecond();
        return builder;
    }
}
