package com.example.digitallibrary.core.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
@Info(title = "Digital-Library API",
        version = "v1",
        description = "documentação da API Digital-Library")
)
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(
                        new io.swagger.v3.oas.models.info.Info()
                                .title("Digital-Library API")
                                .version("v1")
                                .license(
                                        new License()
                                                .name("Apache 2.0") //nome da licença
                                                .url("http://springdoc.org") //any
                                )
                );
    }
}
