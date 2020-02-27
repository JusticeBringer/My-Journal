package com.example.journal.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journal.R;
import com.example.journal.Trip;
import com.example.journal.TripAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;

    private List<Trip> trips;
    private RecyclerView recyclerViewTrips;

    private FloatingActionButton myFab;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        shareViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        myFab = root.findViewById(R.id.idFloatButton);

        recyclerViewTrips = root.findViewById(R.id.idRecyclerViewTrips);

        getTrips();
        setLayoutManager();
        setAdapter();



        return root;
    }

    private void getTrips( ){
        trips = new ArrayList<>();
        trips.add(new Trip("Weekend la munte", "Bucegi",
                "https://valentinatur.md/wp-content/uploads/2017/04/Odihna-la-munte-ucraina-1.jpg",
                "https://cdn.onlinewebfonts.com/svg/img_274147.png",
                Float.parseFloat("3.25")));
        trips.add(new Trip("Astăzi cu bicicleta", "Bucegi",
                "https://static.enjoylehladakh.com/jaipur-to-leh-ladakh-adventure-package-15-nights-16-days-by-flight.jpg",
                "https://cdn.onlinewebfonts.com/svg/img_274147.png",
                Float.parseFloat("4.50")));
        trips.add(new Trip("Astăzi la mare", "Bucegi",
                "https://www.litoralulromanesc.ro/application/views/images/galerie%20imagini/litoral1.jpg",
                "https://cdn.onlinewebfonts.com/svg/img_274147.png",
                Float.parseFloat("2.75")));
    }

    private void setLayoutManager(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewTrips.setLayoutManager(layoutManager);
    }

    private void setAdapter(){
        TripAdapter tripAdapter = new TripAdapter(trips);
        recyclerViewTrips.setAdapter(tripAdapter);
    }

}