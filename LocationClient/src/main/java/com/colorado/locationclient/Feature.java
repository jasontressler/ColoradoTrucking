package com.colorado.locationclient;

public class Feature {

    public String type = "Feature";
    public FeatureProperties properties;
    public FeatureGeometry geometry;

    public Feature(FeatureProperties properties, FeatureGeometry geometry) {
        this.type = "Feature";
        this.properties = properties;
        this.geometry = geometry;
    }

}