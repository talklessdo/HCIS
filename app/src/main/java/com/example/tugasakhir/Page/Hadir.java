package com.example.tugasakhir.Page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tugasakhir.R;

public class Hadir extends AppCompatActivity {

    TextView TVnama,TVjam_masuk,TVjam_keluar,TVtanggal, tvKet;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadir);

        TVnama = findViewById(R.id.namaHadir);
        TVjam_masuk = findViewById(R.id.jamMasukHadir);
        TVjam_keluar = findViewById(R.id.jamKeluarHadir);
        TVtanggal = findViewById(R.id.tanggalHadir);
        tvKet = findViewById(R.id.statusHadir);

        if (getIntent().getExtras() != null) {

            //jika bundle ada, ambil data dari bundle
            bundle = getIntent().getExtras();

            TVnama.setText(bundle.getString("nama"));
            TVjam_masuk.setText(bundle.getString("JamMasuk"));
            TVjam_keluar.setText(bundle.getString("JamKeluar"));
            TVtanggal.setText(bundle.getString("tanggal"));
            tvKet.setText(bundle.getString("keterangan"));
        } else {
            // apabila bundle tidak ada maka ambil dari intent
            TVnama.setText(getIntent().getStringExtra("nama"));
            TVjam_masuk.setText(getIntent().getStringExtra("JamMasuk"));
            TVjam_keluar.setText(getIntent().getStringExtra("JamKeluar"));
            TVtanggal.setText(getIntent().getStringExtra("tanggal"));
            tvKet.setText(bundle.getString("keterangan"));


        }


    }
}