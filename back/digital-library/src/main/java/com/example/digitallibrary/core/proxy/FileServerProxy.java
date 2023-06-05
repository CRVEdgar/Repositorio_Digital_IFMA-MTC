package com.example.digitallibrary.core.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "file-server") //endpoint do cliente/microserviço a ser acessado
public interface FileServerProxy {

    @GetMapping("file-server/download/{identificador}")
    ResponseEntity<?> downloadArquivo(/*@RequestParam(value = "identificador")*/@PathVariable String identificador);

    @PostMapping(value = "file-server/upload{identificador}{titulo}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<?> uploadArquivo(@RequestPart("file") MultipartFile file,
                                           @RequestPart(value = "identificador") String identificador,
                                           @RequestPart(value = "titulo") String titulo);

}
