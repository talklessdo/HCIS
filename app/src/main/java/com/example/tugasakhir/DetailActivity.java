package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private int xid;
    private String xnama,xemail,xttl,xalamat,xtelepon,xgender,xagama,xroles;
    private TextView nama,email,ttl,alamat,telepon,gender,agama,roles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent terima = getIntent();
        xid = terima.getIntExtra("xId", -1);
        xnama = terima.getStringExtra("xNama");
        xemail = terima.getStringExtra("xEmail");
        xttl = terima.getStringExtra("xTgl_lahir");
        xalamat = terima.getStringExtra("xAlamat");
        xtelepon = terima.getStringExtra("xHp");
        xgender = terima.getStringExtra("xGender");
        xagama = terima.getStringExtra("xAgama");
        xroles = terima.getStringExtra("xRoles");

        nama = findViewById(R.id.namaDetail);
        email = findViewById(R.id.emailDetail);
        ttl = findViewById(R.id.ttlDetail);
        alamat = findViewById(R.id.alamatDetail);
        telepon = findViewById(R.id.TeleponDetail);
        gender = findViewById(R.id.GenderDetail);
        agama = findViewById(R.id.AgamaDetail);
        roles = findViewById(R.id.rolesDetail);

        nama.setText(xnama);
        email.setText(xemail);
        ttl.setText(xttl);
        alamat.setText(xalamat);
        telepon.setText(xtelepon);
        if (xgender.equals("L")){
            gender.setText("Laki-Laki");
        }else {
            gender.setText("Perempuan");
        }
        agama.setText(xagama);
        roles.setText(xroles);

    }
}