package dev.fakestore.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger Configuration
 * This class configures Swagger and OpenAPI for documentation visualization and testing
 *
 * @author Misael Landero
 */
@Configuration
public class SwaggerConf {
    @Bean
    public OpenAPI customizeAPI(){
        return new OpenAPI();
    }
}
