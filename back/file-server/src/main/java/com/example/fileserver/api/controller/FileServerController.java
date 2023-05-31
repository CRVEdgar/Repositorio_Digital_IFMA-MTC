package com.example.fileserver.api.controller;

import com.example.fileserver.domain.service.ArquivoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Tag(name = "file-server Endpoint") //LOCAL DE ACESSO - localhost:8200/swagger-ui.html
@RestController
@RequestMapping(value = "file-server")
public class FileServerController {

    private final ArquivoService arquivoService;

    public FileServerController(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }

    @Operation(summary = "Salva as informações do arquivo")
    @PostMapping(value = "/upload{identificador}{titulo}")
    public ResponseEntity<?> uploadArquivo(@RequestParam("file") MultipartFile file,
                                           @RequestParam(value = "identificador") String identificador,
                                           @RequestParam(value = "titulo") String titulo ){
        System.out.println("INICIANDO UPLOAD");
        try{
            return new ResponseEntity<>(
                arquivoService.save(file,
                        identificador,
                        titulo),
                    HttpStatus.CREATED
            ) ;
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @Operation(summary = "Busca um arquivo salvo na base")
//    @GetMapping(value = "/download/{identificador}")
    @GetMapping("/download/{identificador}")
    public ResponseEntity<?> downloadArquivo(/*@RequestParam(value = "identificador")*/@PathVariable String identificador){
        System.out.println("Acessou o endpoint");
        try{

            Resource file = arquivoService.loadAsResource(identificador);
            String nomeArquivo = identificador+".pdf";

            if (file.exists()) {
                System.out.println("Arquivo localizado"); //TODO: remover
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + nomeArquivo);
                headers.setContentType(MediaType.APPLICATION_PDF);

                return ResponseEntity.ok()
                        .headers(headers)
                        .contentLength(file.contentLength())
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(file);
            } else {
                System.out.println("Arquivo nao existe"); //TODO: remover
                return new ResponseEntity<>("Nao foi Possivel Localizar o Arquivo", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
