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
import com.google.firebase.auth.FirebaseUser;

public class autentificare extends AppCompatActivity {

    private EditText idEmailAuth;
    private EditText idPasswordAuth;
    private Button idBtnAuth;

    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentificare);

        initAll();

        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null){
                    Toast.makeText(autentificare.this, "Autentificare reușită", Toast.LENGTH_SHORT);

                    Intent myIntent = new Intent(autentificare.this, LeftMenu.class);
                    startActivity(myIntent);
                }
                else{
                    Toast.makeText(autentificare.this, "Autentificare nereușită", Toast.LENGTH_SHORT);
                }
            }
        };

        idBtnAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = idEmailAuth.getText().toString();
                String pwd = idPasswordAuth.getText().toString();

                if(email.isEmpty()){
                    idEmailAuth.setError("Introduceți email-ul");
                    idEmailAuth.requestFocus();
                }
                else if(pwd.isEmpty()){
                    idPasswordAuth.setError("Introduceti parola");
                    idPasswordAuth.requestFocus();
                }
                else if(email.length() > 3 && pwd.length() > 3){
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(autentificare.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(autentificare.this, "Inregistrare nereușită. Încercați din nou.", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Intent myIntent = new Intent(autentificare.this, LeftMenu.class);
                                startActivity(myIntent);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(autentificare.this, "Eroare. Încercați din nou.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void initAll(){
        idEmailAuth = findViewById(R.id.idEmailAuth);
        idPasswordAuth = findViewById(R.id.idPasswordAuth);
        idBtnAuth = findViewById(R.id.idBtnAuth);
    }

    public void onBackTripClick(View view) {
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
