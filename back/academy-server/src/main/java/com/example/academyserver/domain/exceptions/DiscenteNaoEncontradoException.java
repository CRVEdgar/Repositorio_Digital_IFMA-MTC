package com.example.academyserver.domain.exceptions;

public class DiscenteNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public DiscenteNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public DiscenteNaoEncontradoException(Long codAluno){
        this(String.format("NÃO EXISTE UM CADASTRO DE ALUNO COM CÓDIGO %d", codAluno));
    }
}
