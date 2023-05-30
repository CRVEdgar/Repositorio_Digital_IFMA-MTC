package com.example.fileserver.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Arquivo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificador;
    private String titulo;
    private String fileName;
    private String hashMD5;

    public Arquivo() {
    }

    public Arquivo(String identificador, String titulo, String fileName, String hashMD5) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.fileName = fileName;
        this.hashMD5 = hashMD5;
    }

    public Long getId() {
        return id;
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

    public String getHashMD5() {
        return hashMD5;
    }

    public void setHashMD5(String hashMD5) {
        this.hashMD5 = hashMD5;
    }
}
