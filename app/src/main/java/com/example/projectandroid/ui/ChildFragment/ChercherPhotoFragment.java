package com.example.projectandroid.ui.ChildFragment;

import static android.widget.LinearLayout.HORIZONTAL;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectandroid.Adapters.InterventionAdapter;
import com.example.projectandroid.Adapters.PhotoAdapter;
import com.example.projectandroid.Models.photos;
import com.example.projectandroid.R;

import java.util.ArrayList;
import java.util.List;


public class ChercherPhotoFragment extends Fragment {
    RecyclerView recyclerView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*recyclerView2 =getView().findViewById(R.id.recyclerview2);
        //recycle view linear  (ta7t b3adhhom)
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView2.setLayoutManager(linearLayoutManager);
        recyclerView2.setHasFixedSize(true);
        final List<photos> photoList=new ArrayList<>();
        photoList.add(new photos(R.drawable.images,"test1")) ;
        photoList.add(new photos(R.drawable.images,"test2")) ;*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_chercher_photo, container, false);
        recyclerView2=view.findViewById(R.id.recyclerview2);
        //recycle view linear  (ta7t b3adhhom)
        final List<photos> photoList=new ArrayList<>();
        photoList.add(new photos(R.drawable.images,""));
        photoList.add(new photos(R.drawable.image2,""));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(linearLayoutManager);
        recyclerView2.setHasFixedSize(true);
        //n3adi list intervention
        PhotoAdapter photoAdapter=new PhotoAdapter(photoList,getContext());
        recyclerView2.setAdapter(photoAdapter);
        return view;
    }
}