package com.example.digitallibrary.core.util;

import com.example.digitallibrary.api.DTO.request.ArquivoRequest;
import com.example.digitallibrary.core.exceptions.DomainException;
import com.example.digitallibrary.domain.model.Arquivo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

public class FunctionsUtils {

    public static Arquivo conveteEmArquivo(ResponseEntity<?> responseEntity) {
        Object responseBody = responseEntity.getBody();

        if (responseBody instanceof Arquivo) {
            return (Arquivo) responseBody;
        } else {

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.readValue(responseEntity.getBody().toString(), Arquivo.class);
            } catch (JsonProcessingException e) {
                throw new DomainException("ERRO AO DESSERIALIZAR ARQUIVO");
            }
        }
    }

    public static Arquivo conveteEmArquivo2(ResponseEntity<?> responseEntity) {
        Arquivo arquivo = new Arquivo();
        ObjectMapper objectMapper = new ObjectMapper();

        Object responseBody = responseEntity.getBody();

        try {
            JsonNode jsonNode = objectMapper.readTree(String.valueOf(responseBody));

            arquivo.setIdentificador(jsonNode.get("identificador").asText());
            arquivo.setTitulo(jsonNode.get("titulo").asText());
            arquivo.setFileName(jsonNode.get("fileName").asText());
            return arquivo;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public static  Arquivo convertArquivoMapper(ResponseEntity<?> responseEntity){
        ObjectMapper objectMapper = new ObjectMapper();
        String responsyBody = responseEntity.getBody().toString();

        try {
            Arquivo arquivo = objectMapper.readValue(responseEntity.getBody().toString(), Arquivo.class);
            return arquivo;
        } catch (JsonProcessingException e) {
            throw new DomainException("ERRO AO DESSERIALIZAR ARQUIVO");
        }
    }

    public static Arquivo conveteEmArquivoInstaceOf(ResponseEntity<?> responseEntity) {
        Object responseBody = responseEntity.getBody();
        Arquivo arquivo = null;
        ObjectMapper objectMapper = new ObjectMapper();


        if (responseBody instanceof ArquivoRequest) {
            arquivo = new Arquivo(arquivo.getIdentificador(), arquivo.getTitulo(), arquivo.getFileName());
            return arquivo;
        } else {

            responseEntity.toString();
            throw new DomainException("ERRO AO DESSERIALIZAR ARQUIVO");
        }
    }

}
