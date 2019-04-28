package com.info.eventoutfyp;

import java.io.Serializable;
import java.util.ArrayList;


public class Event implements Serializable {

    private String eventTitle, eventDescription, eventID;
    private String eventDate;
    private String venueID;
    private String eventCapacity;
    private ArrayList<String> categories;
    private String startTime;
    private String endTime;
    private Double eventLat;
    private Double eventLon;
    private String placesName;
    private String category;

    public Event(){}

    public Event(String eventTitle, String venueID, String placesName, String category, String eventDescription, String eventCapacity,
                 String eventDate, String startTime, String endTime,  Double eventLat, Double eventLon) {
        this.eventTitle = eventTitle;
        this.venueID = venueID;
        this.eventDescription = eventDescription;
        this.eventCapacity = eventCapacity;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventLat=eventLat;
        this.eventLon=eventLon;
        this.placesName=placesName;
        this.category = category;
    }



    public String getEventID(){
        return eventID;
    }

    public Double getEventLat(){
        return eventLat;
    }

    public Double getEventLon(){ return eventLon; }

    public String getPlacesName(){return placesName;}

    public String getCategory(){return category;}


    public void setEventID(String eventID){
        this.eventID = eventID;
    }


    public String getEventDescription(){
        return eventDescription;
    }
    public void setEventDescription(String description){
        this.eventDescription = description;
    }

    public String getEventDate(){
        return eventDate;
    }
    public void setEventDate(String date){
        this.eventDate = date;
    }

    public String getEventTitle(){
        return eventTitle;
    }
    public void setEventTitle(String title){
        this.eventTitle = title;
    }


    public String getVenueID(){
        return venueID;
    }
    public void setVenueID(String venueID){
        this.venueID = venueID;
    }

    public String getEventCapacity(){
        return eventCapacity;
    }
    public void setEventCapacity(String capacity){
        this.eventCapacity = capacity;
    }

    public ArrayList<String> getCategories(){
        return categories;
    }

    public void setCategory(ArrayList<String> categories){
        this.categories = categories;
    }

    public void addCategory(String category){
        this.categories.add(category);
    }

    public String getStartTime(){
        return startTime;
    }

    public void setStartTime(String startTime){
        this.startTime = startTime;
    }

    public String getEndTime(){
        return endTime;
    }

    public void setEndTime(String endTime){
        this.endTime = endTime;
    }






    public String toString() {
        return "Event{" +
                "ID='" + eventID + '\'' +
                ", title= '" + eventTitle + '\'' +
                ", description='" + eventDescription + '\'' +
                ", date='" + eventDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", eventCapacity='" + eventCapacity + '\'' +
                ", venueID='" + venueID + '\'' +
                ", categories='" + categories + '\'' +
                '}';
    }



}