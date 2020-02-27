package com.example.journal.ui.contact;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.view.ViewGroup;

import com.example.journal.R;

public class contact extends Fragment {

    private ContactViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        View root = inflater.inflate(R.layout.contact_fragment, container, false);
        return root;
    }
}
