package com.info.eventoutfyp;

public class User {

    String id;
    int type;
    Double lat;
    Double lon;
    String placeName;

    public User(){}

    //constructor for attender
    public User(String id2, int type2){
        this.id= id2;
        this.type= type2;
    }

    //constructor for owner
    public User(String id, int type, Double lat, Double lon, String placeName)
    {
        this.id = id;
        this.type = type;
        this.lat = lat;
        this.lon = lon;
        this.placeName = placeName;

    }

    public String getId()
    {
        return id;
    }



}
