package com.example.journal;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TripViewHolder extends RecyclerView.ViewHolder {

    private ImageView tripPhoto;
    private TextView tripName;
    private TextView tripDestination;
    private RatingBar tripRating;
    private ImageView tripBookmark;


    public TripViewHolder(@NonNull View itemView) {
        super(itemView);

        this.tripPhoto = itemView.findViewById(R.id.idTripPhoto);
        this.tripName = itemView.findViewById(R.id.idTripName);
        this.tripDestination = itemView.findViewById(R.id.idTripDestination);
        this.tripRating = itemView.findViewById(R.id.idTripRating);
        this.tripBookmark = itemView.findViewById(R.id.idTripBookmark);

    }

    public ImageView getTripPhoto() {
        return tripPhoto;
    }

    public TextView getTripName() {
        return tripName;
    }

    public TextView getTripDestination() {
        return tripDestination;
    }

    public RatingBar getTripRating() {
        return tripRating;
    }

    public ImageView getTripBookmark() {
        return tripBookmark;
    }

}
