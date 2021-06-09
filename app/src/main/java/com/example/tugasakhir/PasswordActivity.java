package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugasakhir.Helper.APIConfig;
import com.example.tugasakhir.Helper.APIService;
import com.example.tugasakhir.Helper.UserManager;
import com.google.android.material.textfield.TextInputEditText;

import Model.ResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PasswordActivity extends AppCompatActivity {
    TextView btnPass, IdPass;
    TextInputEditText  password;
    UserManager userManager;
    String cPass, cId;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        IdPass = findViewById(R.id.pass_ID);
        btnPass = findViewById(R.id.btn_CPassword);
        password = findViewById(R.id.Etpassword);
        userManager = new UserManager(this);

        IdPass.setText(userManager.getData().getId());
        password.setText(userManager.getData().getPassword());
        btnPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPass = password.getText().toString();
                cId = IdPass.getText().toString();
                ChangePass();
            }
        });
    }
    private void ChangePass() {
        APIService arData = APIConfig.loadData().create(APIService.class);
        Call<ResponseModel> ChangePass = arData.UpdatePass(cId, cPass);

        ChangePass.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                Toast.makeText(PasswordActivity.this, "kode : " + kode + " | pesan : " + pesan, Toast.LENGTH_SHORT).show();
                finish();

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(PasswordActivity.this, "Gagal Menghubungi Server | " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}