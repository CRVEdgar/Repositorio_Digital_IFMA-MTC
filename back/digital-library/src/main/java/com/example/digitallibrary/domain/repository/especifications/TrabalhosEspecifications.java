package com.example.digitallibrary.domain.repository.especifications;

import com.example.digitallibrary.domain.model.TrabalhoAcademico;
import org.springframework.data.jpa.domain.Specification;

public class TrabalhosEspecifications {

    public static Specification<TrabalhoAcademico> comTituloSemelhante(String titulo){
        return ((root, query, builder) -> builder.like(root.get("titulo"), "%" + titulo + "%"));
    }

    public static Specification<TrabalhoAcademico> comPalavraChaveSemelhante(String palavrasChave){
//        return ((root, query, builder) -> builder.like(root.get("palavras_chave"), "%" + palavrasChave + "%"));
        return ((root, query, builder) -> builder.like(root.get("palavrasChave"), "%" + palavrasChave + "%"));

    }

    public static Specification<TrabalhoAcademico> comResumoSemelhante(String resumo){
        return ((root, query, builder) -> builder.like(root.get("resumo"), "%" + resumo + "%"));
    }


}
