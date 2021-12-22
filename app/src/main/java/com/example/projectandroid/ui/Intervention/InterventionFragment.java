package com.example.projectandroid.ui.Intervention;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.Adapters.InterventionAdapter;
import com.example.projectandroid.Models.Intervention;
import com.example.projectandroid.R;
import com.example.projectandroid.databinding.FragmentHomeBinding;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InterventionFragment extends Fragment {

    private InterventionViewModel interventionViewModel;
    private FragmentHomeBinding binding;
    RecyclerView recyclerView;
    TextView textdate;
    @Nullable

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        interventionViewModel=
                new ViewModelProvider(this).get(InterventionViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Date currentTime= Calendar.getInstance().getTime();
        String FormattedDate= DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);
        textdate=root.findViewById(R.id.editTextDate);
        textdate.setText(FormattedDate);
        recyclerView =root.findViewById(R.id.recyclerview2);
        final List<Intervention> interventionList=new ArrayList<>();
        interventionList.add(new Intervention("Intervention Mobile","Entreprise Exemple 1","Rue paradis","7:00_10:00")) ;
        interventionList.add(new Intervention("Intervention Mobile 2","Entreprise Exemple 2","Rue paradis","8:00_12:00")) ;
        interventionList.add(new Intervention("Intervention Mobile 3","Entreprise Exemple 3","Rue paradis","7:00_10:00")) ;
        interventionList.add(new Intervention("Intervention Mobile 4","Entreprise Exemple 4","Rue paradis","7:00_10:00")) ;
        interventionList.add(new Intervention("Intervention Mobile","Entreprise Exemple 1","Rue paradis","7:00_10:00")) ;
        interventionList.add(new Intervention("Intervention Mobile 2","Entreprise Exemple 2","Rue paradis","8:00_12:00")) ;
        //recycle view linear  (ta7t b3adhhom)
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        //n3adi list intervention
        InterventionAdapter interventionAdapter=new InterventionAdapter(interventionList,getContext());
        recyclerView.setAdapter(interventionAdapter);
        return root;
    }

    /*@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/
}