package com.studys.button_backend;


public class Location{
    private double latitude;
    private double longitude;
    private String locationName;

    public Location(double latitude, double longitude, String locationName){
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationName = locationName;
    }

    public void setLatidude(double latidude) {this.latitude = latidude;}

    public void setLongitude(double longitude) {this.longitude = longitude;}

    public void setLocationName(String locationName) {this.locationName = locationName;}

    public double getLatidude() {return latitude;}

    public double getLongitude() {return longitude;}
    public String getLocationName() {return locationName;}
}