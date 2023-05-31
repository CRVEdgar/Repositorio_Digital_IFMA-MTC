package com.example.digitallibrary.api.DTO.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class TrabalhoRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    private String area;
    @NotBlank
    private String resumo;
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
