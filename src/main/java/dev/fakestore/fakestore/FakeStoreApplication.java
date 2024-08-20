package dev.fakestore.fakestore;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"dev.fakestore.persistance.repository"})
@EntityScan(basePackages = {"dev.fakestore.persistance.entity"})
@OpenAPIDefinition(
		info = @Info(
				title = "Fake Store API",
				version = "1.0",
				description = "REST Services for the Fake Store"),
		servers = {@Server(url = "http://localhost:8080", description = "Local URL")})
@EnableFeignClients(basePackages = {"dev.fakestore.proxy.feign"})
@ComponentScan(basePackages = {
		"dev.fakestore.config",
		"dev.fakestore.domain",
		"dev.fakestore.proxy",
		"dev.fakestore.persistance",
		"dev.fakestore.web",
		"dev.fakestore.fakestore",
		"dev.fakestore.service",

})
public class FakeStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeStoreApplication.class, args);
	}

}
