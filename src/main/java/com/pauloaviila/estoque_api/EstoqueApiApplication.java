package com.pauloaviila.estoque_api; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Varre o projeto inteiro, acha o banco, acha o controller e configura tudo sozinho
public class EstoqueApiApplication { 

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApiApplication.class, args); // Sobe o server
	}
}