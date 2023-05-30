package com.example.academyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**@APINOTE: Servidor de armazenamento de dados dos discente e docentes */
@SpringBootApplication
//@EnableWebMvc
public class AcademyServerApplication implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry){
//        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
//    }
    public static void main(String[] args) {
        SpringApplication.run(AcademyServerApplication.class, args);
    }

}
