package com.nickolss.Produto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nickolss.Produto.controller.dto.SellResponse;
import com.nickolss.Produto.event.ProductEvent;

@SpringBootApplication
public class ProdutoApplication implements CommandLineRunner {
	private final ProductEvent event;
	
	public ProdutoApplication(ProductEvent event) {
		this.event = event;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SellResponse message = new SellResponse(1L, 10, "Product sold successfully 2");
		event.send(message);
		System.out.println("FOI ESSA PORRA");
	}

}
