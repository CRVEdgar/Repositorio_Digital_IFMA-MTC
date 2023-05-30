package com.example.fileserver.domain.repository;

import com.example.fileserver.domain.model.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {

    Optional<Arquivo> findByIdentificador(String identificador);
    Optional<Arquivo> findByFileName(String fileName);
    Optional<Arquivo> findByHashMD5(String hash);
    Optional<Arquivo> findByTitulo(String titulo);


}
