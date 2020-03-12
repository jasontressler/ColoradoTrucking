package com.colorado.locationclient;

import java.util.List;

public class FeatureCollection {
    public String type = "FeatureCollection";
    public List<Feature> features;

    public FeatureCollection(List<Feature> fc){
        this.features = fc;
    }
}