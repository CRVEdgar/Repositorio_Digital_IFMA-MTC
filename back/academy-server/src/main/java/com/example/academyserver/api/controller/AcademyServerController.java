package com.example.academyserver.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "academy-server Endpoint") //LOCAL DE ACESSO - localhost:8100/swagger-ui.html
@RestController
@RequestMapping(value = "academy-server")
public class AcademyServerController {


}
