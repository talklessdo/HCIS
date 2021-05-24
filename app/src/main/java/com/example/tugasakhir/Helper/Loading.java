package com.example.tugasakhir.Helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.tugasakhir.R;

public class Loading {
    private Activity activity;
    private AlertDialog alertDialog;

    public Loading(Activity activity) {
        this.activity = activity;
    }

    public void startLoading(){
        LayoutInflater inflater = activity.getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(inflater.inflate(R.layout.loading,null));
        builder.setCancelable(false);
        alertDialog = builder.create();
        alertDialog.show();
    }

    public void dismiss(){
        alertDialog.dismiss();
    }
}
