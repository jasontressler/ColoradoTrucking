package com.colorado.locationclient;

import java.util.List;

public class GetAllResponse {
    public String message;
    public List<Feature> FeatureCollection;

    public GetAllResponse(String message, List<Feature> featureCollection) {
        this.message = message;
        FeatureCollection = featureCollection;
    }

    public GetAllResponse(String message) {
        this.message = message;
        this.FeatureCollection = null;
    }
}