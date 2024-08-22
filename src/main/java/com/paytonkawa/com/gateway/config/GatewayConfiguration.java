package com.paytonkawa.com.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
@Configuration
public class GatewayConfiguration {


    @Value("${services.customer-service}")
    private String customerServiceUri;

    @Value("${services.command-service}")
    private String commandServiceUri;

    @Value("${services.product-service}")
    private String productServiceUri;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/customer/**")
                                             .uri(customerServiceUri))
                .route("command-service", r -> r.path("/command/**")
                                              .uri(commandServiceUri))
                .route("product-service", r -> r.path("/product/**")
                                                .uri(productServiceUri))
                .build();
    }
}
