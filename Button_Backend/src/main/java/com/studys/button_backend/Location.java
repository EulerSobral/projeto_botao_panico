package com.studys.button_backend;


public class Location{
    private double latidude;
    private double longitude;
    private String locationName;

    public void setLatidude(double latidude) {this.latidude = latidude;}

    public void setLongitude(double longitude) {this.longitude = longitude;}

    public void setLocationName(String locationName) {this.locationName = locationName;}

    public double getLatidude() {return latidude;}

    public double getLongitude() {return longitude;}
    public String getLocationName() {return locationName;}
}