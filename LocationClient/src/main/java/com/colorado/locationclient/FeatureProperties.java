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
    @JsonProperty("distance")
    public double distance;
    @JsonProperty("Nearest_OSName")
    public String nearestOSName;
    @JsonProperty("OS_lat")
    public double OS_Lat;
    @JsonProperty("IS_Lat")
    public double OS_Long;

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

    public Integer getDotNumber() {
        return dotNumber;
    }

    public void setDotNumber(Integer dotNumber) {
        this.dotNumber = dotNumber;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getPhyStreet() {
        return phyStreet;
    }

    public void setPhyStreet(String phyStreet) {
        this.phyStreet = phyStreet;
    }

    public String getPhyCity() {
        return phyCity;
    }

    public void setPhyCity(String phyCity) {
        this.phyCity = phyCity;
    }

    public String getPhyState() {
        return phyState;
    }

    public void setPhyState(String phyState) {
        this.phyState = phyState;
    }

    public String getPhyZip() {
        return phyZip;
    }

    public void setPhyZip(String phyZip) {
        this.phyZip = phyZip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getNearestOSName() {
        return nearestOSName;
    }

    public void setNearestOSName(String nearestOSName) {
        this.nearestOSName = nearestOSName;
    }

    public double getOS_Lat() {
        return OS_Lat;
    }

    public void setOS_Lat(double oS_Lat) {
        OS_Lat = oS_Lat;
    }

    public double getOS_Long() {
        return OS_Long;
    }

    public void setOS_Long(double OS_Long) {
        this.OS_Long = OS_Long;
    }
    
}
