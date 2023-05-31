package com.example.digitallibrary.domain.repository;

import com.example.digitallibrary.domain.model.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {


}
