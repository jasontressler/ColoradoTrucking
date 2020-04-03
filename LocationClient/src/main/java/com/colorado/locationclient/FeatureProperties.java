package com.colorado.locationclient;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeatureProperties {

    @JsonProperty("flag")
    public int flag;
    @JsonProperty("dayDiff")
    public int dayDiff;   
    @JsonProperty("inDOT")
    public String inDOT;
    @JsonProperty("inName")
    public String inName;
    @JsonProperty("inStreet")
    public String inStreet;
    @JsonProperty("inCity")
    public String inCity;
    @JsonProperty("inState")
    public String inState;
    @JsonProperty("inZip")
    public String inZip;
    @JsonProperty("inPhone")
    public String inPhone;
    @JsonProperty("inEmail")
    public String inEmail;
    @JsonProperty("inDate")
    public String inDate;
    @JsonProperty("outDOT")
    public String outDOT;
    @JsonProperty("outName")
    public String outName;
    @JsonProperty("outDate")
    public String outDate;
    @JsonProperty("outReason")
    public String outReason;
    @JsonProperty("outStatus")
    public String outStatus;

    public FeatureProperties(int flag, int dayDiff, String inDOT, String inName, String inStreet, String inCity, String inState,
            String inZip, String inPhone, String inEmail, String inDate, String outDOT, String outName, String outDate,
            String outReason, String outStatus) {
        this.flag = flag;
        this.dayDiff = dayDiff;
        this.inDOT = inDOT;
        this.inName = inName;
        this.inStreet = inStreet;
        this.inCity = inCity;
        this.inState = inState;
        this.inZip = inZip;
        this.inPhone = inPhone;
        this.inEmail = inEmail;
        this.inDate = inDate;
        this.outDOT = outDOT;
        this.outName = outName;
        this.outDate = outDate;
        this.outReason = outReason;
        this.outStatus = outStatus;
    } 
}
