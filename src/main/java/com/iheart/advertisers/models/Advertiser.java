package com.iheart.advertisers.models;

public class Advertiser {
    private String advertiserName;
    private String contactName;
    private Double creditLimit;

    public Advertiser(String advertiserName, String contactName, Double creditLimit) {
        this.advertiserName = advertiserName;
        this.contactName = contactName;
        this.creditLimit = creditLimit;
    }

    public String getName() {
        return advertiserName;
    }

    public void setName(String name) {
        this.advertiserName = name;
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
                "name='" + advertiserName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", creditLimit=" + creditLimit +
                '}';
    }
}
