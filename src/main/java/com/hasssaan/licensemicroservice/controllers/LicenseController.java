package com.hasssaan.licensemicroservice.controllers;

import com.hasssaan.licensemicroservice.model.License;
import com.hasssaan.licensemicroservice.repository.LicenseRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/licenses")
public class LicenseController {
    private final LicenseRepository repository;

    LicenseController(LicenseRepository repository) {
        this.repository = repository;
    }
    //Unprotected endpoints, exposed to public
    @GetMapping("{key}")
    public Boolean isLicenseValid(@PathVariable("key") String key) {
        License license = repository.findByLicenseKey(key);
        if(license == null) {
            return false;
        }
        return !license.isLicenseExpired() && !license.isSharingViolation();
    }
    //Protected Routes, need to add middleware to check for validity of request
    @PostMapping
    public String createLicense(@RequestBody JSONObject jsonBody) {
        License newLicense = new License(jsonBody.get("customerIdentifier").toString());
        repository.insert(newLicense);
        return newLicense.getLicenseKey();
    }

    @PatchMapping("{key}")
    public License renewLicense(@PathVariable("key") String key) {
        License license = repository.findByLicenseKey(key);
        if(license == null) {
            return null;
        }
        license.renew();
        return license;
    }

    @DeleteMapping
    public void clearAll() {
        repository.deleteAll();
    }

}
