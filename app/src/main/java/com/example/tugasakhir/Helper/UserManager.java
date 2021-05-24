package com.example.tugasakhir.Helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tugasakhir.Response.Data;

public class UserManager {
    private static String PREF_NAME = "hcis";
    private static String LOGIN = "logged";
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public UserManager(Context context) {
        this.context = context;
    }

    public void saveUser(Data data){
        String userName = data.getName();
        String userEmail = data.getEmail();
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("name",userName);
        editor.putString("email",userEmail);
        editor.putBoolean(LOGIN,true);
        editor.apply();


    }

    public boolean isLoggIn(){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(LOGIN,false);
    }

    public Data getData(){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return new Data(sharedPreferences.getString("name",null),
                sharedPreferences.getString("email",null));
    }

    public void logout(){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
