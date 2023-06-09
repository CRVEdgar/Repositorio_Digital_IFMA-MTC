package com.example.digitallibrary.api.DTO.response;

public class TrabalhoAcademicoResponse {
    //Mandatory
     private String identificador;

    //Optionals
    private String codAutor;
    private String nomeAutor;
    private String codOrientador;
    private String nomeOrientador;
    private String titulo;
    private String resumo;
    private String area;
    private int ano;
    private String palavrasChave;


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

    public TrabalhoAcademicoResponse andTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public TrabalhoAcademicoResponse andResumo(String resumo) {
        this.resumo = resumo;
        return this;
    }

    public TrabalhoAcademicoResponse andArea(String area) {
        this.area = area;
        return this;
    }

    public TrabalhoAcademicoResponse andAno(int ano) {
        this.ano = ano;
        return this;
    }

    public TrabalhoAcademicoResponse andPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
        return this;
    }

    public TrabalhoAcademicoResponse(String identificador, String codAutor, String nomeAutor, String codOrientador,
                                     String nomeOrientador, String titulo, String resumo, String area, int ano, String palavrasChave) {
        this.identificador = identificador;
        this.codAutor = codAutor;
        this.nomeAutor = nomeAutor;
        this.codOrientador = codOrientador;
        this.nomeOrientador = nomeOrientador;
        this.titulo = titulo;
        this.resumo = resumo;
        this.area = area;
        this.ano = ano;
        this.palavrasChave = palavrasChave;

    }

    /** return Object from Domain Model */
    public TrabalhoAcademicoResponse thatsAll() {
        return new TrabalhoAcademicoResponse(identificador, codAutor, nomeAutor, codOrientador, nomeOrientador,
                titulo, resumo, area, ano, palavrasChave);
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getCodAutor() {
        return codAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getCodOrientador() {
        return codOrientador;
    }

    public String getNomeOrientador() {
        return nomeOrientador;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getArea() {
        return area;
    }

    public int getAno() {
        return ano;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }
}
