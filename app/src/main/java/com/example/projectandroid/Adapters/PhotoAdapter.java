package com.example.projectandroid.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.Models.Intervention;
import com.example.projectandroid.Models.photos;
import com.example.projectandroid.R;
import com.example.projectandroid.detailIntervention;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {
    private List<photos> photoList;
    private Context context;
    public PhotoAdapter(List<photos> photoList, Context context) {
        this.photoList=photoList;
        this.context=context;


    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo,parent,false);
        //mel Intervention viewholder bech yejbed lview
        return new PhotoViewHolder(view);
    }

    @Override

    //t3abi litem mte3ek bel ka3ba bel ka3ba

    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        //nejbed bel position net3ada 3al liste n fois selon nmbre des item
        photos photo=photoList.get(position);
        holder.textViewphoto.setText(photo.getName());
        holder.ImageViewPhoto.setImageResource(photo.getImage());

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }
}

