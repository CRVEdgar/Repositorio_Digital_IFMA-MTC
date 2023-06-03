package com.example.digitallibrary.domain.repository.impl;

import com.example.digitallibrary.domain.model.TrabalhoAcademico;
import com.example.digitallibrary.domain.repository.TrabalhoAcademicoRepository;
import com.example.digitallibrary.domain.repository.TrabalhoAcademicoRepositoryQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.digitallibrary.domain.repository.especifications.TrabalhosEspecifications.*;

@Repository
public class TrabalhoAcademicoRepositoryImpl implements TrabalhoAcademicoRepositoryQueries {
//    @PersistenceContext
//    private EntityManager manager;

    @Autowired @Lazy
    private TrabalhoAcademicoRepository trabalhoAcademicoRepository;

//    @Autowired
//    private ElasticsearchOperations elasticsearchOperations;


//    @Override
//    public List<TrabalhoAcademico> criteriaBuilderJava(String titulo, List<String> palavrasChave) {
//        return null;
//    }
//
//    @Override
//    public List<TrabalhoAcademico> especificationTituloOuPalavraChave(String titulo, String palavrasChave) {
//
//        return trabalhoAcademicoRepository.findAll(
//                comTituloSemelhante(titulo)
//                    .or(comPalavraChaveSemelhante(palavrasChave))
//        );
//
//    }

    @Override
    public List<TrabalhoAcademico> especificationTextoDesejado(String textoSearch) {
        return trabalhoAcademicoRepository.findAll(
                comTituloSemelhante(textoSearch)
                        .or(comPalavraChaveSemelhante(textoSearch))
                        .or(comResumoSemelhante(textoSearch))
        );
    }


}
