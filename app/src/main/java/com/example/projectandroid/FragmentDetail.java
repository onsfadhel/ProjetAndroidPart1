package com.example.projectandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetail extends Fragment {
    //TextView TextViewHour;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("DetailIntervention", Context.MODE_PRIVATE);
//        String Hour=sharedPreferences.getString("Time","erreur");
//        TextViewHour=getActivity().findViewById(R.id.heure12);
//        TextViewHour.setText(Hour);
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }
}
