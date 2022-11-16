package com.hasssaan.licensemicroservice;

import com.hasssaan.licensemicroservice.model.License;
import com.hasssaan.licensemicroservice.repository.LicenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableMongoRepositories
@RestController
public class LicenseMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicenseMicroServiceApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@Bean
	CommandLineRunner runner(LicenseRepository rep) {
		return args -> {
			System.out.println("Hello World!");
//			License newL = new License("Hasssaan");
//			rep.insert(newL);
			License foundUser = rep.findByLicenseKey("9997d8de-aa4a-420c-9f65-44c8ce1d0b5a");
			System.out.println(rep.findAll());
		};
	}
}
