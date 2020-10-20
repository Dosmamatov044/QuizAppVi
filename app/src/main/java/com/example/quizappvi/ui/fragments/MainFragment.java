package com.example.quizappvi.ui.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.Quiztion.QuizActivity;
import com.SpinnerHelper;
import com.example.quizappvi.MainViewModel;
import com.example.quizappvi.R;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends Fragment {


    private static final String ANY_DIFFICULTY = "ANY DIFFICULTY";
    private static final String ANY_CATEGORY = "ANY CATEGORY";
    private static final String EASY = "EASY";
    private static final String MEDIUM = "MEDIUM";
    private static final String HARD = "HARD";
    String difficult;

    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.Bstart)
    Button bStart;

    @BindView(R.id.changetextValue)
    TextView amount;
    @BindView(R.id.category_spinner)
    NiceSpinner categorySpinner;
    @BindView(R.id.difficult_spinner)
    Spinner difficultSpinner;


    private MainViewModel mViewModel = new MainViewModel();

    private int categorySpinner1;
    private String difficultySpinner1;
    private String categoryFromSpinner;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment, container, false);

        ButterKnife.bind(this, root);

        seekbar();

        return root;


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.message.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initCategorySpinner();
        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categorySpinner1 = 0;
                if (categorySpinner.getSelectedIndex() != 0) {
                    categorySpinner1 = categorySpinner.getSelectedIndex() + 8;
                }


                QuizActivity.start(getContext(),
                        seekBar.getProgress(),
                        categorySpinner1
                        , difficultySpinner1,categoryFromSpinner);
            }


        });




        difficultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                difficultySpinner1 = parent.getItemAtPosition(position).toString();
//
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
        private void seekbar () {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                seekBar.setMin(5);
            }


            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                    amount.setText(String.valueOf(Integer.valueOf(progress)));

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }

    private void initCategorySpinner() {
        List<String> category = new LinkedList<>(Collections.singletonList("ANY CATEGORY"));
        category.add("GENERAL KNOWLEDGE");
        category.add("ENTERTAINMENT: BOOKS");
        category.add("ENTERTAINMENT: FILM");
        category.add("ENTERTAINMENT: MUSIC");
        category.add("ENTERTAINMENT: MUSICALS & THEATRES");
        category.add("ENTERTAINMENT: TELEVISION");
        category.add("ENTERTAINMENT: VIDEO GAMES");
        category.add("ENTERTAINMENT: BOARD GAMES");
        category.add("SCIENCE & NATURE");
        category.add("SCIENCE: COMPUTERS");
        category.add("SCIENCE: MATHEMATICS");
        category.add("MYTHOLOGY");
        category.add("SPORTS");
        category.add("GEOGRAPHY");
        category.add("HISTORY");
        category.add("POLITICS");
        category.add("ART");
        category.add("CELEBRITIES");
        category.add("ANIMALS");
        category.add("VEHICLES");
        category.add("ENTERTAINMENT: COMICS");
        category.add("SCIENCE: GADGETS");
        category.add("ENTERTAINMENT: JAPANESE ANIME & MANGA");
        category.add("ENTERTAINMENT: CARTOON & ANIMATIONS");
        SpinnerHelper.set(category, categorySpinner);
    }
    }