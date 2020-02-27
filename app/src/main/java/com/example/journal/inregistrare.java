package com.example.journal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class inregistrare extends AppCompatActivity {

    private EditText idEmailRegister;
    private EditText idNumePrenumeRegister;
    private EditText idPasswordRegister;
    private EditText idConfirmPasswordRegister;
    private Button butonCreareCont;

    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inregistrare);

        initAll();

        butonCreareCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = idEmailRegister.getText().toString();
                String pwd = idPasswordRegister.getText().toString();
                String cfmPwd = idConfirmPasswordRegister.getText().toString();

                if(email.isEmpty()){
                    idEmailRegister.setError("Introduceți email-ul");
                    idEmailRegister.requestFocus();
                }
                else if(pwd.isEmpty()){
                    idPasswordRegister.setError("Introduceti parola");
                    idPasswordRegister.requestFocus();
                }
                else if(!pwd.equals(cfmPwd)){
                    idConfirmPasswordRegister.setError("Parolele sunt diferite");
                    idConfirmPasswordRegister.requestFocus();
                }
                else if(email.length() > 3 && pwd.length() > 3){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(inregistrare.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(inregistrare.this, "Inregistrare nereușită. Încercați din nou.", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                startActivity(new Intent(inregistrare.this, LeftMenu.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(inregistrare.this, "Eroare. Încercați din nou.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void initAll(){
        idEmailRegister = findViewById(R.id.idEmailRegister);
        idNumePrenumeRegister = findViewById(R.id.idNumePrenumeRegister);
        idPasswordRegister = findViewById(R.id.idPasswordRegister);
        idConfirmPasswordRegister = findViewById(R.id.idConfirmPasswordRegister);
        butonCreareCont = findViewById(R.id.idButonCreareCont);

        mFirebaseAuth = FirebaseAuth.getInstance();
    }


    public void onCreareContClick(View view) {
        Intent myIntent = new Intent(getBaseContext(), LeftMenu.class);
        startActivity(myIntent);
    }

    public void onBackTripClick(View view) {
        finish();
    }
}
