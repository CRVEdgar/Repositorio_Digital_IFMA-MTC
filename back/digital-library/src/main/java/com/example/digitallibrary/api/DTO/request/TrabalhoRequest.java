package com.example.digitallibrary.api.DTO.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;


public class TrabalhoRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    private String area;
    @NotBlank
    private String resumo;

    @NotBlank
    private String palavrasChave;
    @NotNull
    @PositiveOrZero
    @JsonProperty("data")
    private int anoPublicacao;
    @NotBlank
    private String codAutor;
    @NotBlank
    private String codOrientador;

    public TrabalhoRequest() {
    }

    public TrabalhoRequest(String titulo, String area, String resumo, String palavrasChave, int anoPublicacao, String codAutor, String codOrientador) {
        this.titulo = titulo;
        this.area = area;
        this.resumo = resumo;
        this.palavrasChave = palavrasChave;
        this.anoPublicacao = anoPublicacao;
        this.codAutor = codAutor;
        this.codOrientador = codOrientador;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArea() {
        return area;
    }

    public String getResumo() {
        return resumo;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }


    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getCodAutor() {
        return codAutor;
    }

    public String getCodOrientador() {
        return codOrientador;
    }

    @Override
    public String toString() {
        return "TrabalhoRequest{" +
                "titulo='" + titulo + '\'' +
                ", area='" + area + '\'' +
                ", resumo='" + resumo + '\'' +
                ", palavrasChave='" + palavrasChave + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", codAutor='" + codAutor + '\'' +
                ", codOrientador='" + codOrientador + '\'' +
                '}';
    }
}
