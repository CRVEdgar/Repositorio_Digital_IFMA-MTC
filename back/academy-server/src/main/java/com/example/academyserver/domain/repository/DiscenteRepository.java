package com.example.academyserver.domain.repository;

import com.example.academyserver.domain.model.Discente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiscenteRepository extends JpaRepository<Discente, Long> {

    Optional<Discente> findByCodigo(String codigo);
    Optional<Discente> findByNome(String nome);
}
