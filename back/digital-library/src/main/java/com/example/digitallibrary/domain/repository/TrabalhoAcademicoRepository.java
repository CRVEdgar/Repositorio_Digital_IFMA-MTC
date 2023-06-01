package com.example.digitallibrary.domain.repository;

import com.example.digitallibrary.domain.model.TrabalhoAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrabalhoAcademicoRepository  extends JpaRepository<TrabalhoAcademico, Long> {

    List<TrabalhoAcademico> findByAno(int ano);

    List<TrabalhoAcademico> findByArea(String area);

}
