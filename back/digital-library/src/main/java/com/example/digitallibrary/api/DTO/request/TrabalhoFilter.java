package com.example.digitallibrary.api.DTO.request;

public class TrabalhoFilter {

    private String titulo;

    private String palavrasChave;

    private String resumo;

    private String textoInformado;

    public TrabalhoFilter() {
    }

    public TrabalhoFilter(String titulo, String palavrasChave, String resumo, String textoInformado) {
        this.titulo = titulo;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.textoInformado = textoInformado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public String getResumo() {
        return resumo;
    }

    public String getTextoInformado() {
        return textoInformado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public void setTextoInformado(String textoInformado) {
        this.textoInformado = textoInformado;
    }
}
