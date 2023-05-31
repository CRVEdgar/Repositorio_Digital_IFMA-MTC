package com.example.digitallibrary.domain.service.impl;

import com.example.digitallibrary.core.exceptions.DomainException;
import com.example.digitallibrary.core.proxy.ParticipanteProxy;
import com.example.digitallibrary.core.proxy.model.Discente;
import com.example.digitallibrary.core.proxy.model.Docente;
import com.example.digitallibrary.domain.model.Membro;
import com.example.digitallibrary.domain.model.enums.VinculoType;
import com.example.digitallibrary.domain.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroServiceImpl implements MembroService {

    private final ParticipanteProxy participanteProxy;

    @Autowired
    public MembroServiceImpl(ParticipanteProxy participanteProxy) {
        this.participanteProxy = participanteProxy;
    }

    @Override
    public Membro buscarAluno(String codAluno) throws DomainException {
        Discente aluno = participanteProxy.buscarAlunoCod(codAluno);

        if(aluno == null){
            throw new DomainException("CÓDIGO DO ALUNO INVÁLIDO");
        }
        Membro autor = new Membro(aluno.getCodigo(), aluno.getNome(), VinculoType.ALUNO);
        return autor;
    }

    @Override
    public Membro buscarProfessor(String codprofesor) throws DomainException {
        Docente professor = participanteProxy.buscarProfessorCod(codprofesor);

        if(professor == null){
            throw new DomainException("CÓDIGO DO PROFESSOR INVÁLIDO");
        }
        Membro orintador = new Membro(professor.getCodigo(), professor.getNome(), VinculoType.PROFESSOR);
        return orintador;
    }
}
