package com.example.academyserver.domain.model;

import com.example.academyserver.domain.model.enums.Curso;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Discente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nome;
    private Curso curso;
    private Boolean ativo = true;

    public Discente() {
    }

    public Discente(String codigo, String nome, Curso curso) {
        this.codigo = codigo;
        this.nome = nome;
        this.curso = curso;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        if (!(o instanceof Discente discente)) return false;
        return Objects.equals(getId(), discente.getId()) && Objects.equals(getCodigo(), discente.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCodigo());
    }
}
