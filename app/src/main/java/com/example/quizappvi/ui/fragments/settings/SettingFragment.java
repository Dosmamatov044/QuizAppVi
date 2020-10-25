package com.example.quizappvi.ui.fragments.settings;

import androidx.databinding.DataBindingUtil;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.QuizApp;

import com.example.quizappvi.R;
import com.example.quizappvi.databinding.SettingFragmentBinding;

import java.util.ArrayList;
import java.util.List;



public class SettingFragment extends Fragment {


    private SettingFragmentBinding binding;
    private List<ThemeModel> list;
    private ListThemeAdapter adapter;
    ThemeModel model;

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.setting_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
        changeTheme();
        clearHistory();
    }

    public void initRecyclerView() {
        list = new ArrayList<>();
        list.add(model =new ThemeModel(R.color.green,false));
        list.add(model =new ThemeModel(R.color.dark,false));
        list.add(model =new ThemeModel(R.color.yellow,false));
        list.add(model =new ThemeModel(R.color.pink,false));
        list.add(model =new ThemeModel(R.color.light_gray,false));
        for (int i = 0; i < list.size(); i++) {
            if (i == QuizApp.preferences.getThemePosition())
                list.get(i).setItCheckout(true);
        }
        adapter = new ListThemeAdapter(list);
        binding.themeRecyclerView.setAdapter(adapter);
    }
    public void changeTheme() {
            binding.ChangeTheme.setOnClickListener(view -> {
                binding.recyclerCardView.setVisibility(View.VISIBLE);
                adapter.setListener(position -> {
                    list.get(position).setItCheckout(true);

                    switch (position){
                        case 0:

                            QuizApp.preferences.saveInstance(R.style.GreenMode);
                            break;
                        case 1:

                            QuizApp.preferences.saveInstance(R.style.DarkMode);
                            break;
                        case 2:
                            QuizApp.preferences.saveInstance(R.style.YellowMode);
                            break;
                        case 3:
                            QuizApp.preferences.saveInstance(R.style.PinkMode);

                            case 4:
                            QuizApp.preferences.saveInstance(R.style.SplashTheme);


                    }
                    QuizApp.preferences.saveInstancePosition(position);
                    Intent intent = requireActivity().getIntent();
                    requireActivity().finish();
                    startActivity(intent);

                });
            });




    }

    public void clearHistory() {
        binding.clear.setOnClickListener(view -> {

                       QuizApp.quizDataBase.quizDao().deleteAll();
                        Toast.makeText(getActivity(), "Удалено", Toast.LENGTH_LONG).show();

        });
    }
}
