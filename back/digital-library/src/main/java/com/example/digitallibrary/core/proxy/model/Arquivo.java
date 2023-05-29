package com.example.digitallibrary.core.proxy.model;

import org.springframework.web.multipart.MultipartFile;

public class Arquivo {

    private String identificador;
    private String titulo;
    private MultipartFile file;

    private String md5Hash;

    public Arquivo() {
    }

    public Arquivo(String identificador, String titulo) {
        this.identificador = identificador;
        this.titulo = titulo;
    }

    public Arquivo(String identificador, String titulo, MultipartFile file, String md5Hash) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.file = file;
        this.md5Hash = md5Hash;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


}
