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
        String userName = data.getNama();
        String userEmail = data.getEmail();
        String userRoles = data.getRoles();
        String userPassword = data.getPassword();
        String userId = data.getId();
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("nama",userName);
        editor.putString("email",userEmail);
        editor.putString("roles",userRoles);
        editor.putString("password", userPassword);
        editor.putString("id", userId);
        editor.putBoolean(LOGIN,true);
        editor.apply();


    }

    public boolean isLoggIn(){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(LOGIN,false);
    }

    public Data getData(){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return new Data(sharedPreferences.getString("nama",null),
                sharedPreferences.getString("email",null),
                sharedPreferences.getString("roles", null),
                sharedPreferences.getString("password", null),
                sharedPreferences.getString("id", null));
    }

    public void logout(){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
