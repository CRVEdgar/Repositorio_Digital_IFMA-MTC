package com.example.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(p -> p.path("/get")//Todo: MODIFICAR PARA get
                        .and().method("POST", "PUT", "GET", "OPTIONS", "DELETE", "PATCH")
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/digital-library/**")
                        .and().method("POST", "PUT", "GET", "OPTIONS", "DELETE", "PATCH")
                        .uri("lb://digital-library"))
                .route(p -> p.path("/academy-server/**")
                        .and().method("POST", "PUT", "GET", "OPTIONS", "DELETE", "PATCH")
                        .uri("lb://academy-server"))
                .route(p -> p.path("/file-server/**")
                        .and().method("POST", "PUT", "GET", "OPTIONS", "DELETE", "PATCH")
                        .uri("lb://file-server"))
                .route("openapi", r -> r.path("/v3/api-docs/**")
                        .and().method("POST", "PUT", "GET", "OPTIONS", "DELETE", "PATCH")
                        .filters(f -> f.rewritePath("/v3/api-docs/(?<path>.*)", "/${path}/v3/api-docs"))
                        .uri("lb://api-gateway"))
                .build();

    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("digital-library", r -> r.path("/digital-library/**")
//                        .and().method("GET", "PUT")
//                        .uri("lb://digital-library"))
//                .route("academy-server", r -> r.path("/academy-server/**")
//                        .and().method("GET", "PUT")
//                        .uri("lb://academy-server"))
//                .route("file-server", r -> r.path("/file-server/**")
//                        .and().method("GET", "PUT")
//                        .uri("lb://file-server"))
//                .route("openapi", r -> r.path("/v3/api-docs/**")
//                        .and().method("GET")
//                        .filters(f -> f.rewritePath("/v3/api-docs/(?<path>.*)", "/${path}/v3/api-docs"))
//                        .uri("lb://api-gateway"))
//                .build();
//    }
}
