package com.hasssaan.licensemicroservice.repository;

import com.hasssaan.licensemicroservice.model.License;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LicenseRepository extends MongoRepository<License, String> {

    License findByLicenseKey(String licenseKey);
}

