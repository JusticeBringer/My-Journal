package com.example.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FirstActivity extends AppCompatActivity {

    private ImageView imageAnglia;
    private ImageView imageRomania;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initAll();
    }

    public void initAll(){
        imageAnglia = findViewById(R.id.imageAnglia);
        imageRomania = findViewById(R.id.imageRomania);
    }

    public void onAngliaClick(View view) {
        Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(myIntent);
    }

    public void onRomaniaClick(View view) {
        Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(myIntent);
    }
}
