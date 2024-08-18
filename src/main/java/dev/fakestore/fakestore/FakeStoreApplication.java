package dev.fakestore.fakestore;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@SecurityScheme(type = SecuritySchemeType.HTTP, name = "javainuseapi", scheme = "basic", in = SecuritySchemeIn.HEADER)
@ComponentScan(basePackages = {
		"dev.fakestore.config",
		"dev.fakestore.web",
		"dev.fakestore.fakestore",
		"dev.fakestore.service",

})
public class FakeStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeStoreApplication.class, args);
	}

}
