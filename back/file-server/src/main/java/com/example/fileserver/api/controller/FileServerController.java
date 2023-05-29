package com.example.fileserver.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "file-server Endpoint") //LOCAL DE ACESSO - localhost:8200/swagger-ui.html
@RestController
@RequestMapping(value = "file-server")
public class FileServerController {
}
