package com.example.digitallibrary.api.DTO.response;

public class TrabalhoAcademicoResponse {
    //Mandatory
     private String identificador;

    //Optionals
    private String codAutor;
    private String nomeAutor;
    private String codOrientador;
    private String nomeOrientador;


    public TrabalhoAcademicoResponse(String identificador) {
        this.identificador = identificador;
    }

    public TrabalhoAcademicoResponse forCodAutor(String codAutor) {
        this.codAutor = codAutor;
        return this; /** return instance of Build */
    }

    public TrabalhoAcademicoResponse andNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
        return this;
    }

    public TrabalhoAcademicoResponse andCodOrientador(String codOrientador) {
        this.codOrientador = codOrientador;
        return this;
    }

    public TrabalhoAcademicoResponse andNomeOrientador(String nomeOrientador) {
        this.nomeOrientador = nomeOrientador;
        return this;
    }

    public TrabalhoAcademicoResponse(String identificador, String codAutor, String nomeAutor, String codOrientador, String nomeOrientador) {
        this.identificador = identificador;
        this.codAutor = codAutor;
        this.nomeAutor = nomeAutor;
        this.codOrientador = codOrientador;
        this.nomeOrientador = nomeOrientador;
    }

    /** return Object from Domain Model */
    public TrabalhoAcademicoResponse thatsAll() {
        return new TrabalhoAcademicoResponse(identificador, codAutor, nomeAutor, codOrientador, nomeOrientador);
    }
}
