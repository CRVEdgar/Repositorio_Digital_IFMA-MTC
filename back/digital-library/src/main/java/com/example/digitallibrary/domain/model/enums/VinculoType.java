package com.example.digitallibrary.domain.model.enums;

public enum VinculoType {

    ALUNO(0, "DISCENTE"),
    PROFESSOR(1, "DOCENTE");

    private Integer code;
    private String tipo;

    VinculoType(Integer code, String tipo) {
        this.code = code;
        this.tipo = tipo;
    }

    public Integer getCode() {
        return code;
    }

    public String getTipo() {
        return tipo;
    }
}
