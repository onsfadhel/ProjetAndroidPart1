package com.example.projectandroid.Adapters;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;

public class InterventionViewHolder extends RecyclerView.ViewHolder{
    TextView textViewinterventionTitle,textViewinterventionadress,textViewinterventiontime,textViewinterventionsociete;
    private RecyclerView.RecyclerListener listener;

    public InterventionViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewinterventionTitle=itemView.findViewById(R.id.interventionTitle);
        textViewinterventionsociete=itemView.findViewById(R.id.interventionsociete);
        textViewinterventionadress=itemView.findViewById(R.id.interventionadress);
        textViewinterventiontime=itemView.findViewById(R.id.interventiontime);

    }
    public InterventionViewHolder(@NonNull View itemView, RecyclerView.RecyclerListener listener){
        super(itemView);
    }
}
