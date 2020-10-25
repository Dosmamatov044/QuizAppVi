package com.example.quizappvi.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.data.remote.HistoryFragment;
import com.example.quizappvi.ui.fragments.MainFragment;
import com.example.quizappvi.ui.fragments.settings.SettingFragment;


public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment = new MainFragment();
                break;
            case 1:
                fragment = new HistoryFragment();
                break;

            default:
                fragment = new SettingFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
