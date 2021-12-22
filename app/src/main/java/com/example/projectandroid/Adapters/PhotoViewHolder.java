package com.example.projectandroid.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;

public class PhotoViewHolder extends RecyclerView.ViewHolder{
    TextView textViewphoto;
    ImageView ImageViewPhoto;
    private RecyclerView.RecyclerListener listener;

    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewphoto=itemView.findViewById(R.id.textViewPhoto);
        ImageViewPhoto=itemView.findViewById(R.id.imageViewPhoto);
    }
}
