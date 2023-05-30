package com.example.fileserver.core.exceptions;

public class ArquivoNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public ArquivoNaoEncontradoException(String cod){
        super("NÃO EXISTE CADASTRO DE ARQUIVO COM IDENTIFICADOR: "+cod);
    }

//    public DiscenteNaoEncontradoException(String codAluno){
//        this( codAluno );
//    }
}
