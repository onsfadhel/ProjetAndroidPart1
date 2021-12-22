package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HistoriqueActivity extends AppCompatActivity {
    TextView textviewtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        SharedPreferences sharedPreferences = getSharedPreferences("DetailIntervention", Context.MODE_PRIVATE);
        String titreIntervention=getIntent().getStringExtra("Title");
        textviewtitle=findViewById(R.id.textViewtitleintervention2);
        textviewtitle.setText(titreIntervention);

    }
}