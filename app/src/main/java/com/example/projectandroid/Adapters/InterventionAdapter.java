package com.example.projectandroid.Adapters;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.Models.Intervention;
import com.example.projectandroid.R;
import com.example.projectandroid.detailIntervention;

import java.util.List;

public class InterventionAdapter extends RecyclerView.Adapter<InterventionViewHolder> {
    private List<Intervention> InterventionList;
    private Context context;
    public InterventionAdapter(List<Intervention> interventionList,Context context) {
        this.InterventionList=interventionList;
        this.context=context;


    }

    @NonNull
    @Override
    public InterventionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_intervention,parent,false);
        //mel Intervention viewholder bech yejbed lview
        return new InterventionViewHolder(view);
    }
    //t3abi litem mte3ek bel ka3ba bel ka3ba

    @Override
    public void onBindViewHolder(@NonNull InterventionViewHolder holder, int position) {
        //nejbed bel position net3ada 3al liste n fois selon nmbre des item
        Intervention intervention=InterventionList.get(position);
        holder.textViewinterventionTitle.setText(intervention.getTitle());
        holder.textViewinterventionsociete.setText(intervention.getSociete());
        holder.textViewinterventionadress.setText(intervention.getAddress());
        holder.textViewinterventiontime.setText(intervention.getTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, detailIntervention.class);
                intent.putExtra("Title",intervention.getTitle());
                intent.putExtra("Societe",intervention.getSociete());
                intent.putExtra("Address",intervention.getAddress());
                intent.putExtra("Time",intervention.getTime());
                //créer un fichier
                SharedPreferences sharedPreferences= context.getSharedPreferences("userinformations",Context.MODE_PRIVATE);
                //créer une copie du fichier
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("Title",intervention.getTitle());
                editor.putString("Societe",intervention.getSociete());
                editor.putString("Address",intervention.getAddress());
                editor.putString("Time",intervention.getTime());
                //save modification
                editor.commit();
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return InterventionList.size();
    }
}
