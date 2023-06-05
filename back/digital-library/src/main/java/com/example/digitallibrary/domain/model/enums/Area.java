package com.example.digitallibrary.domain.model.enums;

import com.example.digitallibrary.core.exceptions.DomainException;

public enum Area {

    MATEMATICA(0, "MATEMATICA", "Matematica, Calculo, Raciocínio Lógico"),
    LETRAS(1, "LETRAS", "Linguagens, Literatura, Gramatica"),
    COMPUTAÇÃO(2, "COMPUTAÇÃO", "Tecnologia, Ciencia de Dados, Inteligencia Artificial"),
    ENGENHARIA(3, "ENGENHARIA" , "Engenharia, Produção, Inovação"),
    EDUCACAO(4, "EDUCACAO", "Educação, Ensino, Aprendizagem"),
    BIOLOGIA(5, "BIOLOGIA", "Biologia, Ecossistema, Saude, Animal, Vegetal, Natureza");

    private Integer code;
    private String reference;
    private String area;

    Area(Integer code, String reference, String area) {
        this.code = code;
        this.reference =  reference;
        this.area = area;
    }

    public Integer getCode() {
        return code;
    }

    public String getArea() {
        return area;
    }

    public String getReference() {
        return reference;
    }

    public static Area toEnum(String area){
        System.out.println("Area buscada: " + area);
        for (Area tipo: Area.values()){
            if(area.equalsIgnoreCase(tipo.area)){
                return tipo;
            }
        }
        throw new DomainException("DESCRIÇÃO DA AREA DO TRABALHO INVALIDA");
    }
}
