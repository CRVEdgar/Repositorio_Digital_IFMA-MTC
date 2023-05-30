package com.example.fileserver.core.exceptions;

public abstract class EntidadeNaoEncontradaException extends ServiceException {
    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException (String mensagem){
        super(mensagem);
    }
}
