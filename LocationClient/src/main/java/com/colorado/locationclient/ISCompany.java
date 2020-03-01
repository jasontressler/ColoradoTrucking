package com.colorado.locationclient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"DOT_NUMBER",
"LEGAL_NAME",
"DBA_NAME",
"CARRIER_OPERATION",
"HM_FLAG",
"PC_FLAG",
"PHY_STREET",
"PHY_CITY",
"PHY_STATE",
"PHY_ZIP",
"PHY_COUNTRY",
"MAILING_STREET",
"MAILING_CITY",
"MAILING_STATE",
"MAILING_ZIP",
"MAILING_COUNTRY",
"TELEPHONE",
"FAX",
"EMAIL_ADDRESS",
"MCS150_DATE",
"MCS150_MILEAGE",
"MCS150_MILEAGE_YEAR",
"ADD_DATE",
"OIC_STATE",
"NBR_POWER_UNIT",
"DRIVER_TOTAL",
"GPSLatitude",
"GPSLongitude"
})

public class ISCompany {

@JsonProperty("DOT_NUMBER")
public Integer dotNumber;
@JsonProperty("name")
public String legalName;
@JsonProperty("DBA_NAME")
public String dbName;
@JsonProperty("CARRIER_OPERATION")
public String carrierOperation;
@JsonProperty("HM_FLAG")
public String hmFlag;
@JsonProperty("PC_FLAG")
public String pcFlag;
@JsonProperty("address")
public String phyStreet;
@JsonProperty("city")
public String phyCity;
@JsonProperty("PHY_STATE")
public String phyState;
@JsonProperty("zip")
public String phyZip;
@JsonProperty("PHY_COUNTRY")
public String phyCountry;
@JsonProperty("MAILING_STREET")
public String mailingStreet;
@JsonProperty("MAILING_CITY")
public String mailingCity;
@JsonProperty("MAILING_STATE")
public String mailingState;
@JsonProperty("MAILING_ZIP")
public String mailingZip;
@JsonProperty("MAILING_COUNTRY")
public String mailingCountry;
@JsonProperty("phone")
public String telephone;
@JsonProperty("FAX")
public String fax;
@JsonProperty("email")
public String emailAddress;
@JsonProperty("MCS150_DATE")
public String mcs150Date;
@JsonProperty("MCS150_MILEAGE")
public Integer mcs150Mileage;
@JsonProperty("MCS150_MILEAGE_YEAR")
public Integer mcs150MileageYear;
@JsonProperty("ADD_DATE")
public String addDate;
@JsonProperty("OIC_STATE")
public String oicState;
@JsonProperty("NBR_POWER_UNIT")
public Integer nbrPowerUnit;
@JsonProperty("DRIVER_TOTAL")
public Integer driverTotal;
@JsonProperty("latitude")
public Double gpsLatitude;
@JsonProperty("longitude")
public Double gpsLongitude;

}