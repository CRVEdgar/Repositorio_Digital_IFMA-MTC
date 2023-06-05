package com.example.digitallibrary.api.DTO.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ArquivoRequest /*implements Serializable*/ {
//    private static final long serialVersionUID = 1L;
    @JsonProperty("identificador")
    private String identificador;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("fileName")
    private String fileName;

    public ArquivoRequest() {
    }

    public ArquivoRequest(String identificador, String titulo, String fileName) {
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
