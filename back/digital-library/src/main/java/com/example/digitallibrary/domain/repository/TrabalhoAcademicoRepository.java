package com.example.digitallibrary.domain.repository;

import com.example.digitallibrary.domain.model.TrabalhoAcademico;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface TrabalhoAcademicoRepository  extends JpaRepository<TrabalhoAcademico, Long>,
//            TrabalhoAcademicoRepositoryCriteria, JpaSpecificationExecutor<TrabalhoAcademico> {
    public interface TrabalhoAcademicoRepository  extends CustomJpaRepository<TrabalhoAcademico, Long>,
        TrabalhoAcademicoRepositoryQueries, JpaSpecificationExecutor<TrabalhoAcademico> {

    List<TrabalhoAcademico> findByAno(int ano);

    List<TrabalhoAcademico> findByArea(String area);

}
