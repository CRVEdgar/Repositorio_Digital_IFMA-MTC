package com.example.digitallibrary.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean //orienta o spring a ignorar a instanciação de uma implementação para esta interface
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID> {


}

