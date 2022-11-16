package com.hasssaan.licensemicroservice.model;

import org.springframework.data.annotation.Id;

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

    public License() {}

    public License(String customerIdentifier) {
        Calendar c = (Calendar.getInstance());
        c.add(Calendar.DATE, 30);
        this.licenseKey = UUID.randomUUID().toString();
        this.expirationDate = c.getTime();
        this.renewalAmount = 0;
        this.customerIdentifier = customerIdentifier;
    }

    @Override
    public String toString() {
        return String.format(
                "License[id=%s, licenseKey='%s', expirationDate='%s', renewalAmount='%s', customerIdentifier='%s']",
                id, licenseKey, expirationDate, renewalAmount, customerIdentifier);
    }

}
