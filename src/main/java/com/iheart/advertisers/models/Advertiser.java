package com.iheart.advertisers.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Class Representing the Advertiser model throughout the flow of the application")
public class Advertiser {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    @ApiModelProperty(notes = "A unique identifier of the Advertiser. It'll be confusing to have multiple advertisers.",
            example = "Batman", required = true, position = 1)
    private String advertiserName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 300)
    @ApiModelProperty(notes = "ContactName for the Advertiser.",
            example = "Bruce Wayne", position = 2)
    private String contactName;

    @NotNull
    @ApiModelProperty(notes = "Credit Limit for the Advertiser. How much the credit the advertiser has to spend.",
            example = "10000.00", position = 3)
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
