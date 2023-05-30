package com.example.academyserver.domain.service;

import com.example.academyserver.domain.model.enums.Curso;
import com.example.academyserver.domain.model.enums.Departamento;
import com.example.academyserver.domain.service.impl.DiscenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class teste {

    public static void main(String[] args) {

        Curso curso = Curso.MTM;
        LocalDateTime sufix = LocalDateTime.now();
        String builder = sufix.getYear()+curso.toString()+sufix.getMinute()+sufix.getSecond();

        Departamento depto =  Departamento.DECOMP;
        String codeprof = sufix.getYear()+depto.toString()+sufix.getMinute()+sufix.getSecond();


        System.out.println("BUILDER: " + builder + " CODE PROF: " + codeprof);

    }
}
