package com.example.fileserver.api.DTO;

import java.io.Serializable;

public class ArquivoResponse /*implements Serializable*/ {
//    private static final long serialVersionUID = 1L;
    
    private String identificador;
    private String titulo;
    private String fileName;

    public ArquivoResponse() {
    }

    public ArquivoResponse(String identificador, String titulo, String fileName) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.fileName = fileName;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
