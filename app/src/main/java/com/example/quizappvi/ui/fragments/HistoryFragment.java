package com.example.quizappvi.ui.fragments;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.example.AdapterHistory.AdapterH;
import com.example.quizappvi.R;
import com.example.quizappvi.ui.HistoryViewModel;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class HistoryFragment extends Fragment {

    ClassHis classHis;
    Button add;
    public static String a, b, c, d, e;

    private AdapterH adapter;
    private ArrayList<ClassHis> list = new ArrayList<ClassHis>();


    private HistoryViewModel mViewModel;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        add = view.findViewById(R.id.add);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new AdapterH(list, getActivity());
        recyclerView.setAdapter(adapter);


        for (int i = 0; i <= 2; i++) {

            classHis = new ClassHis("Category:", " 8_10", " Mixed", "CorrectAnswers:", "Difficulty:", "  Easy", "7");

            list.add(classHis);
            adapter.notifyDataSetChanged();
        }


    }

















    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history_fragment, container, false);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);

    }







}
