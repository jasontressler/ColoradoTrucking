package com.colorado.locationclient;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeatureGeometry {
    @JsonProperty("latitude")
    public Double gpsLatitude;
    @JsonProperty("longitude")
    public Double gpsLongitude;

    public FeatureGeometry(Double gpsLatitude, Double gpsLongitude) {
        this.gpsLatitude = gpsLatitude;
        this.gpsLongitude = gpsLongitude;
    }
}
