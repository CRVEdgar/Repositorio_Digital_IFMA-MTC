package com.example.academyserver.domain.exceptions;

public class DocenteNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public DocenteNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public DocenteNaoEncontradoException(Long codProf){
        this(String.format("NÃO EXISTE UM CADASTRO DE POFESSOR COM CÓDIGO %d", codProf));
    }
}
