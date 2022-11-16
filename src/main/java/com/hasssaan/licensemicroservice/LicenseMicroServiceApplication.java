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


}
