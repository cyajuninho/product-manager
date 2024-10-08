package br.com.cya.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfiguration {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("authenticationModule", r -> r.path("/users/**")
                        .uri("lb://authentication-service")
                )

                .route("productModule", r -> r.path("/products/**")
                        .uri("lb://product-service")
                )
                .build();
    }
}
