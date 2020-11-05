package com.example.reheaven.ui.message;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reheaven.R;

public class fragment_message extends Fragment {

    private FragmentMessageViewModel messageViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        messageViewModel =
                ViewModelProviders.of(this).get(FragmentMessageViewModel.class);
        View root = inflater.inflate(R.layout.fragment_message, container, false);
        return root;
    }

}
