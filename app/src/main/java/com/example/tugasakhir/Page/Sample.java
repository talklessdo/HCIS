package com.example.tugasakhir.Page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tugasakhir.R;

public class Sample extends AppCompatActivity {

    TextView txt1, txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        txt1 = findViewById(R.id.textView2);
        txt2 = findViewById(R.id.textView3);

        Intent ambil = getIntent();
        String id = ambil.getStringExtra("idUser");
        txt1.setText("id "+id);
        txt2.setText(ambil.getStringExtra("nama"));
    }
}