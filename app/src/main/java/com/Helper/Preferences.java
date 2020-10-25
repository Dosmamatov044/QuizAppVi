package com.Helper;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    public static final String PREF_THEME = "theme";
    private SharedPreferences preferences;
    public static volatile Preferences instance;

    public Preferences(Context context) {
        instance = this;
        preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    public static Preferences getInstance (Context context){
        if (instance==null){
            new Preferences(context); }
        return instance;
    }



    public void saveInstance(int theme){

        preferences.edit().putInt(PREF_THEME,theme).apply();
    }
    public int getTheme(int defTheme){
      return   preferences.getInt(PREF_THEME,defTheme);
    }

    public void saveInstancePosition(int pos){

        preferences.edit().putInt(PREF_THEME + "position",pos).apply();
    }
    public int getThemePosition(){
      return   preferences.getInt(PREF_THEME + "position",0);
    }
}
