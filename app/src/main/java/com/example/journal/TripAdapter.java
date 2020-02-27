package com.example.journal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripViewHolder>  implements View.OnClickListener{

    private List<Trip> trips;
    private Integer count = 0;


    public TripAdapter(List<Trip> trips){
        this.trips = trips;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_recycler_view, parent, false);
        return new TripViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        Trip currentTrip = trips.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditTrip.class);
                v.getContext().startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(v.getContext(), ReadTripActivity.class);
                v.getContext().startActivity(intent);

                return false;
            }
        });

        if(currentTrip.getTripPhoto() != null){
            Picasso.get().load(currentTrip.getTripPhoto()).into(holder.getTripPhoto());
        }
        else{
            Picasso.get().load(R.drawable.ic_launcher_background).into(holder.getTripPhoto());
        }

        if(currentTrip.getTripBookmark() != null){
            Picasso.get().load(currentTrip.getTripBookmark()).into(holder.getTripBookmark());
        }
        else {
            Picasso.get().load(R.drawable.ic_launcher_background).into(holder.getTripBookmark());
        }

        holder.getTripName().setText(currentTrip.getTripName());
        holder.getTripDestination().setText(currentTrip.getTripDestination());
        holder.getTripRating().setRating(currentTrip.getTripRating());

    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    @Override
    public void onClick(View v) {

    }
}
