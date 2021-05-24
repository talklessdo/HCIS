package com.example.tugasakhir.Page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tugasakhir.Helper.UserManager;
import com.example.tugasakhir.Login;
import com.example.tugasakhir.R;

public class Profile extends AppCompatActivity {

    UserManager userManager;
    TextView nameProf,emailProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userManager = new UserManager(this);
        nameProf = findViewById(R.id.namaProfile);
        emailProf = findViewById(R.id.emailProfile);

        nameProf.setText(userManager.getData().getName());
        emailProf.setText(userManager.getData().getEmail());

    }

    public void logout(View view) {
        userManager.logout();
        Intent intent = new Intent(Profile.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        finish();
    }
}