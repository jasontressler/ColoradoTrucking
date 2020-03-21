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
public Integer DotNumber;
@JsonProperty("name")
public String LegalName;
@JsonProperty("DBA_NAME")
public String DbaName;
@JsonProperty("CARRIER_OPERATION")
public String CarrierOperation;
@JsonProperty("HM_FLAG")
public String HmFlag;
@JsonProperty("PC_FLAG")
public String PcFlag;
@JsonProperty("address")
public String PhyStreet;
@JsonProperty("city")
public String PhyCity;
@JsonProperty("PHY_STATE")
public String PhyState;
@JsonProperty("zip")
public String PhyZip;
@JsonProperty("PHY_COUNTRY")
public String PhyCountry;
@JsonProperty("MAILING_STREET")
public String MailingStreet;
@JsonProperty("MAILING_CITY")
public String MailingCity;
@JsonProperty("MAILING_STATE")
public String MailingState;
@JsonProperty("MAILING_ZIP")
public String MailingZip;
@JsonProperty("MAILING_COUNTRY")
public String MailingCountry;
@JsonProperty("phone")
public String Telephone;
@JsonProperty("FAX")
public String Fax;
@JsonProperty("email")
public String EmailAddress;
@JsonProperty("MCS150_DATE")
public String Mcs150Date;
@JsonProperty("MCS150_MILEAGE")
public Integer Mcs150Mileage;
@JsonProperty("MCS150_MILEAGE_YEAR")
public Integer mcs150MileageYear;
@JsonProperty("ADD_DATE")
public String AddDate;
@JsonProperty("OIC_STATE")
public String OicState;
@JsonProperty("NBR_POWER_UNIT")
public Integer NbrPowerUnit;
@JsonProperty("DRIVER_TOTAL")
public Integer DriverTotal;
@JsonProperty("latitude")
public Double GpsLatitude;
@JsonProperty("longitude")
public Double GpsLongitude;

}