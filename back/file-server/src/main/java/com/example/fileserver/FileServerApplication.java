package com.example.fileserver;

import com.example.fileserver.core.util.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**@APINOTE: Servidor de armazenamento e compartilhamento de arquivos entre usuários da rede IFMA-MTC */
@SpringBootApplication
public class FileServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileServerApplication.class, args);
    }

    @PostConstruct
    public void init(){
        FileUtils.PATH_TO_FILES = "repositorio/fileSystem";
        System.out.println("****** Diretorio Raiz gerado: " + FileUtils.gerarDiretorioRaiz());
    }

}
