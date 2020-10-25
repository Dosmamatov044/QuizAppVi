package com.example.quizappvi.ui.fragments.History;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;


import com.QuizApp;
import com.example.AdapterHistory.AdapterH;
import com.example.quizappvi.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment implements AdapterH.Listener {
    int position;
    private AdapterH adapter;
   List<History> list = new ArrayList<>();
 RecyclerView recyclerView;
AdapterH.Listener listener;
    private HistoryViewModel mViewModel;
    public static HistoryFragment newInstance() {
        return new HistoryFragment();}


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      mViewModel= ViewModelProviders.of(getActivity()).get(HistoryViewModel.class);

     recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
         adapter=new AdapterH(this);

        recyclerView.setAdapter(adapter);
       adapter.updateList(new ArrayList<>());

mViewModel.history.observe(getActivity(),histories -> {

    if (histories!=null){
       list=histories;

        adapter.updateList((list));


    }



});
mViewModel.deleteById.observe(getActivity(),aVoid -> QuizApp.historyStorage.deleteAll());


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





    private void showPopupMenu(View view, int position) {
        this.position = position;
        PopupMenu popupMenu = new PopupMenu(getContext(), view);
        popupMenu.inflate(R.menu.history_menu);

        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.deleteH) {
                QuizApp.quizDataBase.quizDao().deleteById(list.get(position).getId());


                Toast.makeText(getContext(), "deleted", Toast.LENGTH_SHORT).show();


                return true;
            }
            return false;
        });
        popupMenu.show();
    }


    @Override
    public void onClick(View view, int id) {

        showPopupMenu(view,id);

    }
}
