package com.example.digitallibrary.core.proxy;

import com.example.digitallibrary.domain.model.Arquivo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "file-server") //endpoint do cliente/microserviço a ser acessado
@Component
public interface FileServerProxy {

    //TODO: ajustar os endpoints
    @GetMapping(value = "file-server/{titulo}/{identificador}")
    public Arquivo capturarArquivo(@PathVariable("titulo") String titulo, @PathVariable("identificador") String identificadorArquivo);

    @PostMapping(value = "file-server/save")
    public Arquivo armazenarArquivo(@PathVariable("titulo") String titulo,
                                    @PathVariable("identificador") String identificadorArquivo,
                                    @RequestBody MultipartFile file);

}
