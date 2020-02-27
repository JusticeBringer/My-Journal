package com.example.journal.ui.share;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.journal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ShareViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ShareViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share fragment");



    }

    public LiveData<String> getText() {
        return mText;
    }


}