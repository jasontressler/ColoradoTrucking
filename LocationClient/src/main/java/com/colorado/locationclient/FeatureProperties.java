package com.colorado.locationclient;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeatureProperties {

    @JsonProperty("id")
    public Integer dotNumber;
    @JsonProperty("name")
    public String legalName;
    @JsonProperty("street")
    public String phyStreet;
    @JsonProperty("city")
    public String phyCity;
    @JsonProperty("state")
    public String phyState;
    @JsonProperty("zip")
    public String phyZip;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("email")
    public String emailAddress;

    public FeatureProperties(Integer dotNumber, String legalName, String phyStreet, String phyCity, String phyState,
            String phyZip, String phone, String emailAddress) {
        this.dotNumber = dotNumber;
        this.legalName = legalName;
        this.phyStreet = phyStreet;
        this.phyCity = phyCity;
        this.phyState = phyState;
        this.phyZip = phyZip;
        this.phone = phone;
        this.emailAddress = emailAddress;
    }
}
