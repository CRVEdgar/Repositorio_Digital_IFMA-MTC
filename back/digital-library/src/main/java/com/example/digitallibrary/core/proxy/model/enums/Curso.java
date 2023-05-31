package com.example.digitallibrary.core.proxy.model.enums;

public enum Curso {

    SI("Sistemas de Informação", Departamento.DECOMP),
    BIO("Biologia", Departamento.DAB),
    LQ("Quimica", Departamento.DAQ),
    MTM("Matematica", Departamento.DEMAT),
    FIS("Fisica", Departamento.DFIS),
    ENG_EL("Engenharia Eletrica", Departamento.DEE),
    ENG_CIV("Engenharia Civil", Departamento.DCC),
    ENG_MEC("Engenharia Mecanica", Departamento.DMM);

    private String name;
    private Departamento departamento;

    Curso(String name, Departamento departamento) {
        this.name = name;
        this.departamento = departamento;
    }

    public String getName() {
        return name;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
