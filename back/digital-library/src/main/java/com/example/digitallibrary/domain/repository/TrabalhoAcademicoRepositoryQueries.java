package com.example.digitallibrary.domain.repository;

import com.example.digitallibrary.domain.model.TrabalhoAcademico;

import java.util.List;

public interface TrabalhoAcademicoRepositoryQueries {
//    List<TrabalhoAcademico> criteriaBuilderJava(String titulo, List<String> palavrasChave );
//
//    List<TrabalhoAcademico> especificationTituloOuPalavraChave(String titulo, String palavrasChave );

    List<TrabalhoAcademico> especificationTextoDesejado(String textoSearch);

}
