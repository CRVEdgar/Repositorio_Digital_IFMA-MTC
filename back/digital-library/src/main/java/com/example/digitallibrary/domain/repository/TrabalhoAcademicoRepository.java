package com.example.digitallibrary.domain.repository;

import com.example.digitallibrary.domain.model.TrabalhoAcademico;
import com.example.digitallibrary.domain.model.enums.Area;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrabalhoAcademicoRepository  extends CustomJpaRepository<TrabalhoAcademico, Long>,
        TrabalhoAcademicoRepositoryQueries, JpaSpecificationExecutor<TrabalhoAcademico> {

    List<TrabalhoAcademico> findByAno(int ano);

    List<TrabalhoAcademico> findByArea(Area area);

    TrabalhoAcademico findByArquivo_Identificador(String identificador);

}
