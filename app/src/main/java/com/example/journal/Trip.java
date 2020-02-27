package com.example.journal;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;

public class Trip {
    private String tripName;
    private String tripDestination;
    private String tripType;
    private Float tripPrice;
    private String tripStartDate;
    private String tripEndDate;
    private Float tripRating;
    private String tripPhoto;
    private String tripBookmark;

    public Trip(String tripName, String tripDestination, String tripType, Float tripPrice, String tripStartDate, String tripEndDate, Float tripRating, String tripPhoto) {
        this.tripName = tripName;
        this.tripDestination = tripDestination;
        this.tripType = tripType;
        this.tripPrice = tripPrice;
        this.tripStartDate = tripStartDate;
        this.tripEndDate = tripEndDate;
        this.tripRating = tripRating;
        this.tripPhoto = tripPhoto;
    }

    public Trip(String tripName, String tripDestination, String tripPhoto, String tripBookmark,  Float tripRating) {
        this.tripName = tripName;
        this.tripDestination = tripDestination;
        this.tripRating = tripRating;
        this.tripPhoto = tripPhoto;
        this.tripBookmark = tripBookmark;
    }

    public Trip(String tripName, String tripDestination){
        this.tripName = tripName;
        this.tripDestination = tripDestination;
    }

    public Trip(){

    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public void setTripDestination(String tripDestination) {
        this.tripDestination = tripDestination;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public void setTripPrice(Float tripPrice) {
        this.tripPrice = tripPrice;
    }

    public void setTripStartDate(String tripStartDate) {
        this.tripStartDate = tripStartDate;
    }

    public void setTripEndDate(String tripEndDate) {
        this.tripEndDate = tripEndDate;
    }

    public void setTripRating(Float tripRating) {
        this.tripRating = tripRating;
    }

    public void setTripPhoto(String tripPhoto) {
        this.tripPhoto = tripPhoto;
    }

    public void setTripBookmark(String tripBookmark) {
        this.tripBookmark = tripBookmark;
    }

    public String getTripBookmark() {
        return tripBookmark;
    }

    public String getTripName() {
        return tripName;
    }

    public String getTripDestination() {
        return tripDestination;
    }

    public String getTripType() {
        return tripType;
    }

    public Float getTripPrice() {
        return tripPrice;
    }

    public String getTripStartDate() {
        return tripStartDate;
    }

    public String getTripEndDate() {
        return tripEndDate;
    }

    public Float getTripRating() {
        return tripRating;
    }

    public String getTripPhoto() {
        return tripPhoto;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripRating=" + tripRating +
                '}';
    }
}
