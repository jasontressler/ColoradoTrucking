package com.colorado.locationclient;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FeatureGeometry {
    public double[] coordinates;
    @JsonIgnore
    public Double gpsLatitude;
    @JsonIgnore
    public Double gpsLongitude;

    public FeatureGeometry(Double gpsLatitude, Double gpsLongitude) {
        coordinates = new double[] {gpsLatitude, gpsLongitude};
    }
}
