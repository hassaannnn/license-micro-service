package com.hasssaan.licensemicroservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class License {

    @Id
    public String id;

    public String licenseKey;
    public Date expirationDate;
    public int renewalAmount;
    public String customerIdentifier;
    public int activeSessions;
    public boolean sharingViolation;

    public License() {}

    public License(String customerIdentifier) {
        Calendar c = (Calendar.getInstance());
        c.add(Calendar.DATE, 30);
        this.licenseKey = UUID.randomUUID().toString();
        this.expirationDate = c.getTime();
        this.renewalAmount = 0;
        this.customerIdentifier = customerIdentifier;
        this.activeSessions = 0;
        this.sharingViolation = false;
    }
    public boolean isLicenseExpired() {
        return this.expirationDate.before(Calendar.getInstance().getTime());
    }

    public void renew() {
        Calendar c = (Calendar.getInstance());
        c.add(Calendar.DATE, 30);
        this.expirationDate = c.getTime();
        this.renewalAmount++;
    }

    public void renew(int daysToAdd) {
        Calendar c = (Calendar.getInstance());
        c.add(Calendar.DATE, daysToAdd);
        this.expirationDate = c.getTime();
        this.renewalAmount++;
    }







    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getRenewalAmount() {
        return renewalAmount;
    }

    public void setRenewalAmount(int renewalAmount) {
        this.renewalAmount = renewalAmount;
    }

    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    public void setCustomerIdentifier(String customerIdentifier) {
        this.customerIdentifier = customerIdentifier;
    }

    public int getActiveSessions() {
        return activeSessions;
    }

    public void setActiveSessions(int activeSessions) {
        this.activeSessions = activeSessions;
    }

    public boolean isSharingViolation() {
        return sharingViolation;
    }

    public void setSharingViolation(boolean sharingViolation) {
        this.sharingViolation = sharingViolation;
    }

    @Override
    public String toString() {
        return String.format(
                "License[id=%s, licenseKey='%s', expirationDate='%s', renewalAmount='%s', customerIdentifier='%s']",
                id, licenseKey, expirationDate, renewalAmount, customerIdentifier);
    }

}
