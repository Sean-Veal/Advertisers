package com.iheart.advertisers.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Advertiser {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    private String advertiserName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    private String contactName;

    @NotNull
    private Double creditLimit;

    public Advertiser() {}

    public Advertiser(String advertiserName, String contactName, Double creditLimit) {
        this.advertiserName = advertiserName;
        this.contactName = contactName;
        this.creditLimit = creditLimit;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Advertiser{" +
                "advertiserName='" + advertiserName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", creditLimit=" + creditLimit +
                '}';
    }
}
