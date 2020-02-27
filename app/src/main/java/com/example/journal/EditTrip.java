package com.example.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class EditTrip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_trip);
    }

    public void onBackTripClick(View view) {
        finish();
    }

    public void onAddSaveClick(View view) {
    }

    public void onAddCancelClick(View view) {
    }
}
