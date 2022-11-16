package com.hasssaan.licensemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableMongoRepositories
@RestController
public class LicenseMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicenseMicroServiceApplication.class, args);
    }


}
