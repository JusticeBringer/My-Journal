package com.example.journal.ui;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.journal.LeftMenu;
import com.example.journal.MainActivity;
import com.example.journal.R;
import com.google.firebase.auth.FirebaseAuth;

public class Logout extends Fragment {

    private LogoutViewModel mViewModel;

    private Button logoutBtn;

    public static Logout newInstance() {
        return new Logout();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.logout_fragment, container, false);

        logoutBtn = root.findViewById(R.id.btnDeconectare);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent myIntent = new Intent(getActivity(), MainActivity.class);
                startActivity(myIntent);
            }
        });

        return root;
    }



}
