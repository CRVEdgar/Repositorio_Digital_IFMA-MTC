package com.example.digitallibrary.domain.service;

import com.example.digitallibrary.core.exceptions.DomainException;
import com.example.digitallibrary.domain.model.Membro;

public interface MembroService {

    Membro buscarAluno(String codAluno) throws DomainException;
    Membro buscarProfessor(String codprofesor) throws DomainException;

}
