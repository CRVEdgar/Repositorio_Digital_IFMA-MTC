package com.example.digitallibrary.api.DTO.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TrabalhoRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    private String area;
    @NotBlank
    private String resumo;

//    @NotNull
//    private List<String> palavrasChave = new ArrayList<>();
    @NotBlank
    private String palavrasChave;
    @NotNull
    @PositiveOrZero
    private int anoPublicacao;
    @NotBlank
    private String codAutor;
    @NotBlank
    private String codOrientador;

    public TrabalhoRequest() {
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
//    public List<String> getPalavrasChave() {
//        return palavrasChave;
//    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getCodAutor() {
        return codAutor;
    }

    public String getCodOrientador() {
        return codOrientador;
    }
}
