package com.example.digitallibrary;

import com.example.digitallibrary.core.proxy.FileServerProxy;
import com.example.digitallibrary.core.proxy.ParticipanteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DigitalLibraryApplication {

//    private final ParticipanteProxy participanteProxy;
    private final FileServerProxy fileServerProxy;

    @Autowired
    public DigitalLibraryApplication(/*ParticipanteProxy participanteProxy,*/ FileServerProxy fileServerProxy) {
//        this.participanteProxy = participanteProxy;
        this.fileServerProxy = fileServerProxy;
    }

    public static void main(String[] args) {
        SpringApplication.run(DigitalLibraryApplication.class, args);
    }

}
