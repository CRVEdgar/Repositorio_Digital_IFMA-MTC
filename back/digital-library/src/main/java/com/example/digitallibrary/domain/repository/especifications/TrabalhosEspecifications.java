package com.example.digitallibrary.domain.repository.especifications;

import com.example.digitallibrary.domain.model.TrabalhoAcademico;
import org.springframework.data.jpa.domain.Specification;

public class TrabalhosEspecifications {

    public static Specification<TrabalhoAcademico> comTituloSemelhante(String titulo){
        return ((root, query, builder) -> builder.like(builder.lower(root.get("titulo")), "%" + titulo.toLowerCase() + "%"));
    }

    public static Specification<TrabalhoAcademico> comPalavraChaveSemelhante(String palavrasChave){
        return ((root, query, builder) -> builder.like(builder.lower(root.get("palavrasChave")), "%" + palavrasChave.toLowerCase() + "%"));
    }

    public static Specification<TrabalhoAcademico> comResumoSemelhante(String resumo){
        return ((root, query, builder) -> builder.like(builder.lower(root.get("resumo")), "%" + resumo.toLowerCase() + "%"));
    }


}
