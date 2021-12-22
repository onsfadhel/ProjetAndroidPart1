package com.example.projectandroid.ui.InterventionAssigner;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InterventionAssignerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InterventionAssignerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}