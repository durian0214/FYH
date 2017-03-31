package com.fyh.search.bean;

import java.io.Serializable;

/**
 * Created by Aramis on 2017/3/9.
 */

public class SearchLocationBean implements Serializable {
    private String name;
    private double longtitude;
    private double latitude;

    public SearchLocationBean() {

    }

    public SearchLocationBean(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "SearchLocationBean{" +
                "name='" + name + '\'' +
                ", longtitude=" + longtitude +
                ", latitude=" + latitude +
                '}';
    }
}
