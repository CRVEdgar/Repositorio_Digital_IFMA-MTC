package com.example.digitallibrary.core.proxy.model;

import com.example.digitallibrary.core.proxy.model.enums.Departamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String codigo;
    private String nome;
    private Departamento departamento;
    private Boolean ativo = true;

    public Docente() {
    }

    public Docente(String codigo, String nome, Departamento departamento) {
        this.codigo = codigo;
        this.nome = nome;
        this.departamento = departamento;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Boolean getVinculo() {
        return ativo;
    }

    public void desvincular() {
        this.ativo = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Docente docente)) return false;
        return Objects.equals(getId(), docente.getId()) && Objects.equals(getCodigo(), docente.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCodigo());
    }
}
