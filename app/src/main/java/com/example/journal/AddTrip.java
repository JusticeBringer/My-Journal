package com.example.journal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddTrip extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private List<Trip> trips;
    private boolean startOrEnd = true;

    private EditText idAddTripName;
    private EditText idAddTripDestination;
    private RadioGroup idAddTripType;
    private SeekBar idAddSeekBar;
    private TextView idAddTripPrice;

    private TextView idAddTripStart;
    private TextView idAddTripEnd;
    private Button idendDateBtn;
    private Button idstartDateBtn;

    private RatingBar idAddTripRating;
    private TextView idAddTripPhotoSelected;
    private Button idAddPhotoFromGallery;
    private Button idAddPhotoWithCamera;

    private Button idAddTripCancel;
    private Button idAddTripSave;

    private RecyclerView recyclerViewTrips;
    private TripAdapter tripAdapter;

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private FirebaseUser user;

    private static int counterTrip = 0;

    private FirebaseAuth.AuthStateListener mAuthListener;

    ArrayList<Trip> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        initAll();

        idstartDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
                startOrEnd = true;
            }
        });

        idendDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
                startOrEnd = false;
            }
        });

        idAddSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                idAddTripPrice.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = database.getReference("Trips");


        idAddTripSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterTrip += 1;

                Trip trip = new Trip(idAddTripName.getText().toString(), idAddTripDestination.getText().toString());
                mDatabase.child("trip" + counterTrip).setValue(trip);

                final String[] radioText = new String[1];
                idAddTripType.setOnCheckedChangeListener((group, checkedId) -> {
                    int id = group.getCheckedRadioButtonId();
                    RadioButton rb = (RadioButton) findViewById(id);

                    radioText[0] = rb.getText().toString();
                });

                //TODO not working
                mDatabase.push().setValue(radioText[0]);

                finish();
            }
        });

        saveData();
    }

    public void saveData(){

    }

    public void onAddSaveClick(View view) {

    }

    private void getTrips(){
        trips.add(new Trip("Prima relaxare", "Bucegi",
                "https://riverbreak.com/wp-content/uploads/background-waves-01.png",
                "https://cdn.onlinewebfonts.com/svg/img_274147.png",
                Float.parseFloat("3.25")));
        trips.add(new Trip("Prima relaxare", "Bucegi",
                "https://riverbreak.com/wp-content/uploads/background-waves-01.png",
                "https://cdn.onlinewebfonts.com/svg/img_274147.png",
                Float.parseFloat("3.25")));
        trips.add(new Trip("Prima relaxare", "Bucegi",
                "https://riverbreak.com/wp-content/uploads/background-waves-01.png",
                "https://cdn.onlinewebfonts.com/svg/img_274147.png",
                Float.parseFloat("3.25")));

        tripAdapter = new TripAdapter(trips);
    }

    private void setLayoutManager(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerViewTrips.setLayoutManager(layoutManager);
    }

    private void setAdapter(){
        recyclerViewTrips.setAdapter(tripAdapter);
    }

    public void initAll(){
        trips = new ArrayList<>();

        setContentView(R.layout.fragment_home);
        recyclerViewTrips = findViewById(R.id.idRecyclerViewTrips);
        setContentView(R.layout.activity_add_trip);

        idAddTripName = findViewById(R.id.idAddTripName);
        idAddTripDestination = findViewById(R.id.idAddTripDestination);
        idAddTripType = findViewById(R.id.idAddTripType);
        idAddSeekBar = findViewById(R.id.idAddSeekBar);
        idAddTripPrice = findViewById(R.id.idAddTripPrice);

        idAddTripStart = findViewById(R.id.idAddTripStart);
        idAddTripEnd = findViewById(R.id.idAddTripEnd);
        idstartDateBtn = findViewById(R.id.idstartDateBtn);
        idendDateBtn = findViewById(R.id.idendDateBtn);

        idAddTripRating = findViewById(R.id.idAddTripRating);
        idAddTripPhotoSelected = findViewById(R.id.idAddTripPhotoSelected);
        idAddPhotoFromGallery = findViewById(R.id.idAddPhotoFromGallery);
        idAddPhotoWithCamera = findViewById(R.id.idAddPhotoWithCamera);

        idAddTripCancel = findViewById(R.id.idAddTripCancel);
        idAddTripSave = findViewById(R.id.idAddTripSave);
    }

    public void onBackTripClick(View view) {
        finish();
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + month + "/" + year;
        if (startOrEnd) {
            idAddTripStart.setText(date);
        } else {
            idAddTripEnd.setText(date);
        }
    }

    public void onAddCancelClick(View view) {
        finish();
    }

}
