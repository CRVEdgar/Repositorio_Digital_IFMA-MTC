package com.example.digitallibrary.core.proxy;

import com.example.digitallibrary.domain.model.Arquivo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "file-server") //endpoint do cliente/microserviço a ser acessado
public interface FileServerProxy {

    @GetMapping("/download/{identificador}")
    ResponseEntity<?> downloadArquivo(/*@RequestParam(value = "identificador")*/@PathVariable String identificador);

    @PostMapping(value = "/upload{identificador}{titulo}")
    ResponseEntity<?> uploadArquivo(@RequestParam("file") MultipartFile file,
                                           @RequestParam(value = "identificador") String identificador,
                                           @RequestParam(value = "titulo") String titulo);

}
