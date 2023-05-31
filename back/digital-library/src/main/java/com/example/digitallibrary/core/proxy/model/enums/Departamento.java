package com.example.digitallibrary.core.proxy.model.enums;

public enum Departamento {
    DECOMP(0, "Departamento Acadêmico de Computação"),
    DAB(1, "Departamento Acadêmico de Biologia"),
    DAQ(2, "Departamento Acadêmico de Química"),
    DEMAT(3, "Departamento Acadêmico de Matemática"),
    DFIS(4, "Departamento Acadêmico de Física"),
    DEE(5, "Departamento Acadêmico de Eletroeletrônica"),
    DCC(6, "Departamento Acadêmico de Construção Civil"),
    DMM(7, "Departamento Acadêmico de Mecânica e Materiais");

    private Integer code;
    private String name;

    Departamento(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
