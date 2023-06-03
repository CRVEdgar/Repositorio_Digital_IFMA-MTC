package com.example.digitallibrary;

import com.example.digitallibrary.domain.repository.impl.CustomJpaRepositoryImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class DigitalLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalLibraryApplication.class, args);
    }

}
