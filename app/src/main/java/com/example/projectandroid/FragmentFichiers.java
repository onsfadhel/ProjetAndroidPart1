package com.example.projectandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.projectandroid.ui.ChildFragment.ChercherPhotoFragment;
import com.example.projectandroid.ui.ChildFragment.PrendrePhotoFragment;
import com.google.android.material.tabs.TabLayout;

public class FragmentFichiers extends Fragment {
    TabLayout tabLayout3;
    ViewPager viewPager3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*LinearLayout linearLayout;
        //linearLayout=getActivity().findViewById(R.id.container);
        ChercherPhotoFragment chercherPhotoFragment=new ChercherPhotoFragment();
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container);*/

        View view=inflater.inflate(R.layout.fragment_fichiers,container,false);
        addFragment(view);
        return view;
    }

    private void addFragment(View view) {
        tabLayout3=view.findViewById(R.id.tabLayout3);
        viewPager3=view.findViewById(R.id.viewPager3);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new ChercherPhotoFragment(),"Chercher Photo ");
        adapter.addFragment(new PrendrePhotoFragment(),"Prendre Photo ");
        viewPager3.setAdapter(adapter);
        tabLayout3.setupWithViewPager(viewPager3);
    }
}
