package com.pizzaria.gerenciador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class GerenciadorPizzariaApp {
	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPizzariaApp.class, args);
	}
	
}
