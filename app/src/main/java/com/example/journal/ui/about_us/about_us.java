package com.example.journal.ui.about_us;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.journal.R;
import com.example.journal.ui.about_us.AboutUsViewModel;
import com.example.journal.ui.home.HomeViewModel;

public class about_us extends Fragment {

    private AboutUsViewModel mViewModel;

    public static about_us newInstance() {
        return new about_us();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(AboutUsViewModel.class);
        View root = inflater.inflate(R.layout.about_us_fragment, container, false);

            /*
                final TextView textView = root.findViewById(R.id.text_home);
                homeViewModel.getText().observe(this, new Observer<String>() {
                @Override
                public void onChanged (@Nullable String s){
                    textView.setText(s);
                }
            });

             */

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AboutUsViewModel.class);
        // TODO: Use the ViewModel
    }

}
