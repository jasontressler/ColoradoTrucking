package com.colorado.locationclient;

import java.util.List;

public class FeatureResponse extends Response {
    
    public FeatureCollection body;

    public FeatureResponse(String message, List<Feature> featureList) {
        this.message = message;
        this.body = new FeatureCollection(featureList);
    }
}