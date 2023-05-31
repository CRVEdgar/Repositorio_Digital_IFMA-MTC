package com.example.digitallibrary.domain.model.enums;

public enum Area {

    MATEMATICA(0, "Matematica, Calculo, Raciocínio Lógico"),
    LETRAS(1, "Linguagens, Literatura, Gramatica"),
    COMPUTAÇÃO(2, "Tecnologia, Ciencia de Dados, Inteligencia Artificial"),
    ENGENHARIA(3, "Engenharia, Produção, Inovação"),
    EDUCACAO(4, "Educação, Ensino, Aprendizagem");

    private Integer code;
    private String area;

    Area(Integer code, String area) {
        this.code = code;
        this.area = area;
    }

    public Integer getCode() {
        return code;
    }

    public String getArea() {
        return area;
    }
}
