package com.hasssaan.licensemicroservice.repository;

import com.hasssaan.licensemicroservice.model.License;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface LicenseRepository extends MongoRepository<License, String> {

    public License findByLicenseKey(String licenseKey);
}

