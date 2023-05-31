package com.example.digitallibrary.domain.model;

import com.example.digitallibrary.domain.model.enums.VinculoType;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Membro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nome;
    private VinculoType vinculoType;
    @ManyToOne
    @JoinColumn(name="membro_id", nullable = false)
    private TrabalhoAcademico trabalhoAcademico;

    public Membro() {
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

    public VinculoType getVinculoType() {
        return vinculoType;
    }

    public void setVinculoType(VinculoType vinculoType) {
        this.vinculoType = vinculoType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Membro membro)) return false;
        return Objects.equals(getId(), membro.getId()) && Objects.equals(getCodigo(), membro.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCodigo());
    }
}
