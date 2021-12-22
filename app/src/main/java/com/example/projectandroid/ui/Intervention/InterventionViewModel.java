package com.example.projectandroid.ui.Intervention;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InterventionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InterventionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}