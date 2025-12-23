package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Server server = new Server();
        server.setUrl("https://9146.32procr.amypo.ai/");
        server.setDescription("Production Server");

        SecurityScheme bearerAuth = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        return new OpenAPI()
                // Server
                .servers(List.of(server))

                // API Info
                .info(new Info()
                        .title("Asset Lifecycle Tracking API")
                        .version("1.0")
                        .description("API for managing asset lifecycle tracking"))

                // Apply JWT globally
                .addSecurityItem(
                        new SecurityRequirement().addList("Bearer Authentication")
                )

                // Components
                .components(new Components()
                        .addSecuritySchemes("Bearer Authentication", bearerAuth)
                );
    }
}
