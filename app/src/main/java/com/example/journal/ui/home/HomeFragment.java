package com.example.journal.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journal.AddTrip;
import com.example.journal.R;
import com.example.journal.Trip;
import com.example.journal.TripAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private List<Trip> trips;
    private RecyclerView recyclerViewTrips;

    private TextView id_greeting_nume;

    private TextView userName;
    private TextView userEmail;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        id_greeting_nume = root.findViewById(R.id.id_greeting_nume);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        String email = user.getEmail();
        String toPut = email.substring(email.indexOf(" ") + 1, email.indexOf("."));
        toPut = toPut.substring(0, 1).toUpperCase() + toPut.substring(1);

        id_greeting_nume.setText(toPut);


        /*userName = root.findViewById(R.id.idUserName);
        userEmail = root.findViewById(R.id.idUserEmail);

        userName.setText(toPut);
        userEmail.setText(email);*/


        FloatingActionButton fab = root.findViewById(R.id.idFloatButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(root.getContext(), AddTrip.class);
                startActivity(myIntent);
            }
        });

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
        trips.add(new Trip("Astăzi cu bicicleta", "Munții Bucegi",
                "https://static.enjoylehladakh.com/jaipur-to-leh-ladakh-adventure-package-15-nights-16-days-by-flight.jpg",
                "https://cdn.onlinewebfonts.com/svg/img_274147.png",
                Float.parseFloat("4.50")));
        trips.add(new Trip("Astăzi la mare", "La Marea Neagră",
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