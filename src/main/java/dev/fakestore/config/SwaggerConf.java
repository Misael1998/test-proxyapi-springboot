package dev.fakestore.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
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
    /**
     * <p>
     *     This method configures OpenAPI documentation
     * </p>
     * @return OpenAPI
     */
    @Bean
    public OpenAPI customizeAPI(){
        final String securitySchemeName = "Authorization Bearer";
        return new OpenAPI()
                .components(
                        new Components()
                                .addSecuritySchemes(
                                        securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                );
    }
}
