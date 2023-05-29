package com.example.digitallibrary.core.proxy.model;

public class Participantes {

    private String matricula;

    private String nome;
    private String tipoVinculo;
    private String email;

    public Participantes() {
    }

    public Participantes(String matricula, String nome, String tipoVinculo) {
        this.matricula = matricula;
        this.nome = nome;
        this.tipoVinculo = tipoVinculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(String tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }
}
