package com.example.academyserver.domain.repository;

import com.example.academyserver.domain.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

    Optional<Docente> findByCodigo(String codigo);
    Optional<Docente> findByNome(String nome);

}
