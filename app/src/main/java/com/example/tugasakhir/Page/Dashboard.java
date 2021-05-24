package com.example.tugasakhir.Page;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tugasakhir.Helper.UserManager;
import com.example.tugasakhir.R;

import java.util.Calendar;

public class Dashboard extends AppCompatActivity {



    UserManager userManager;
    TextView currentTime,UserName;
    Calendar calendar;
    int jam, menit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        userManager = new UserManager(this);
        UserName = findViewById(R.id.name);

        UserName.setText(userManager.getData().getName());
        currentTime = findViewById(R.id.zona);
        calendar = Calendar.getInstance();

        jam = calendar.get(Calendar.HOUR_OF_DAY);
        menit = calendar.get(Calendar.MINUTE);
        if (jam >= 12 && jam < 15){
            currentTime.setText("Selamat Siang");
        }
        if (jam >= 15 && jam < 19){
            currentTime.setText("Selamat Sore");
        }
        if (jam >= 19 && jam < 1){
            currentTime.setText("Selamat Malam");
        }if (jam >= 1 && jam < 12){
            currentTime.setText("Selamat Pagi");
        }

    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.icon_petik)
                .setTitle(R.string.app_name)
                .setMessage("Yakin ingin keluar aplikasi ?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();

    }

    public void akun(View view) {
        startActivity(new Intent(Dashboard.this, Profile.class));
    }


    public void izin(View view) {
        startActivity(new Intent(Dashboard.this,Izin.class));
    }
}