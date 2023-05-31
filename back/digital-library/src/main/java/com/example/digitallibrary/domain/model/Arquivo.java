package com.example.digitallibrary.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificador;
    private String titulo;
    private String fileName;

    public Arquivo() {
    }

    public Arquivo(String identificador, String titulo, String fileName) {
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

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arquivo arquivo)) return false;
        return Objects.equals(getId(), arquivo.getId()) && Objects.equals(getIdentificador(), arquivo.getIdentificador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIdentificador());
    }
}
