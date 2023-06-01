package com.example.digitallibrary.domain.repository;

import com.example.digitallibrary.domain.model.TrabalhoAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhoAcademicoRepository  extends JpaRepository<TrabalhoAcademico, Long> {
}
