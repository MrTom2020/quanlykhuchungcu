package com.example.reheavenadmin.ui.quanlycudan;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.reheavenadmin.R;
import com.example.reheavenadmin.adapter.ResidentAdapter;
import com.example.reheavenadmin.model.ResidentModel;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class QuanlycudanFragment extends Fragment {

    private QuanlycudanViewModel quanlycudanViewModelViewModel;

    List<ResidentModel> residentModel;

    ResidentAdapter adapter;

    NavController navController;
    ImageView imgthemcudan;

    Unbinder unbinder;

    private RecyclerView recycler_resident;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        quanlycudanViewModelViewModel = ViewModelProviders.of(this).get(QuanlycudanViewModel.class);
        View root = inflater.inflate(R.layout.quanlycudan_fragment, container, false);
        recycler_resident = (RecyclerView)root.findViewById(R.id.recycler_resident);
        init();
        unbinder = ButterKnife.bind(this, root);
        quanlycudanViewModelViewModel.getResidentModelList().observe(this, residentModelList -> {
            residentModel = residentModelList;
            adapter = new ResidentAdapter(getContext(), residentModel);
            ResidentAdapter residentAdapter = new ResidentAdapter(getContext(), residentModelList);
            recycler_resident.setAdapter(residentAdapter);
        });

        return root;
    }

    private void init() {
        recycler_resident.setHasFixedSize(true);
        recycler_resident.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
    }

    @Override
    public void onViewCreated(@NonNull View root, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(root, savedInstanceState);
        navController = Navigation.findNavController(root);

        imgthemcudan = root.findViewById(R.id.imgthemcudan);
        imgthemcudan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_quanlycudan_to_nav_themcudan);
            }
        });


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}