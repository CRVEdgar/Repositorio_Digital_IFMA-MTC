package com.example.apigateway.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
/**define a configuração da documentação no swagger*/
public class OpenApiConfiguration {

    @Bean
    @Lazy(false)
    public List<GroupedOpenApi> apis(
            SwaggerUiConfigParameters config,
            RouteDefinitionLocator locator) {


        var definitions = locator.getRouteDefinitions().collectList().block();

        definitions.stream().filter(
                        routeDefinition -> routeDefinition.getId()
                                .matches(".*-service"))
                .forEach(routeDefinition -> {
                            String name = routeDefinition.getId();
                            config.addGroup(name);
                            GroupedOpenApi.builder()
                                    .pathsToMatch("/" + name + "/**")
                                    .group(name).build();
                        }
                );
        return new ArrayList<>();
    }

    /** pode ser feito em uma classe de configuração ou no yml*/
//    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route( p -> p.path("/get")
//                        .filters(f -> f
//                                .addRequestHeader("ff", "ff")
//                                .addRequestParameter("hh","hh"))
//                        .uri("httpbin.org:80"))
//                .route(p -> p.path("/URIENDEREÇO/**").uri("lb://cambio-service"))
//                .build();
//
//    }
}
