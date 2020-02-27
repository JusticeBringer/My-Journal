package com.example.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button butonRegister;
    private Button butonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAll();
    }

    public void initAll(){
        butonRegister = findViewById(R.id.butonRegister);
        butonLogin = findViewById(R.id.butonLogin);
    }


    public void onRegisterClick(View view) {
        Intent myIntent = new Intent(getBaseContext(), inregistrare.class);
        startActivity(myIntent);
    }

    public void onLoginClick(View view) {
        Intent myIntent = new Intent(getBaseContext(), autentificare.class);
        startActivity(myIntent);
    }
}
