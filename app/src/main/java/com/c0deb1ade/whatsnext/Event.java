package com.c0deb1ade.whatsnext;


import java.io.Serializable;

public class Event implements Serializable{
    // Date of the event
    private String date;
    // Organizer of the event
    private String organizer;
    // Title of the event
    private String title;
    // Description of the event
    private String description;
    // Venue of the event
    private String venue;
    // Time of the event
    private String time;
    // google form url for registration
    private String googleFormUrl;
    // photo url of the event
    private String photo;

    public Event(){
    }

    public Event(String organizer,String title, String description, String venue, String date, String time, String googleFormUrl, String photo) {
        this.organizer = organizer;
        this.title = title;
        this.description = description;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.googleFormUrl = googleFormUrl;
        this.photo = photo;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getVenue() {
        return venue;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getGoogleFormUrl() {
        return googleFormUrl;
    }

    public String getPhoto() {
        return photo;
    }
}
