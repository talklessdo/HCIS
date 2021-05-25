package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tugasakhir.Helper.UserManager;

public class Sample extends AppCompatActivity {

    TextView name,email;

    UserManager userManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        name = findViewById(R.id.namaUser);
        email = findViewById(R.id.emailUser);
        userManager = new UserManager(this);
        String userName = userManager.getData().getNama();
        String userEmail = userManager.getData().getEmail();

        name.setText(userName);
        email.setText(userEmail);


    }

    public void out(View view) {
        userManager.logout();
        Intent intent = new Intent(Sample.this,Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        finish();
    }
}