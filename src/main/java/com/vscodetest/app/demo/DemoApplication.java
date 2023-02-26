package com.vscodetest.app.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vscodetest.app.demo.service.LojaService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private LojaService lojaService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		lojaService.makeShoppingRuns();
	}

}
