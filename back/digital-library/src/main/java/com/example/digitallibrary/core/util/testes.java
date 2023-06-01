package com.example.digitallibrary.core.util;

import com.example.digitallibrary.domain.model.enums.Area;

public class testes {
    public static void main(String[] args) {
//        String value = FileUtil.gerarIdentificador("20182SI0027", "DOC-2018UTT");
//        System.out.println("VALOR: " +value);

        String area = "Matematica, Calculo, Raciocínio Lógico";
        String area1 = "Engenharia, Produção, Inovação";
        String area2 = "Tecnologia, Ciencia";

        Area areaEnum = Area.toEnum(area);
        System.out.println("to string: " +areaEnum.toString() );
        System.out.println("ENUM: " +areaEnum );


    }
}
