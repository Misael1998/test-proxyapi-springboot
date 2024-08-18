package dev.fakestore.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConf {
    @Bean
    public OpenAPI customizeAPI(){
        return new OpenAPI();
    }
}
