package com.example.tugasakhir;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasakhir.Helper.APIConfig;
import com.example.tugasakhir.Helper.APIService;
import com.example.tugasakhir.Helper.Loading;
import com.example.tugasakhir.Helper.UserManager;
import com.example.tugasakhir.Page.Dashboard;
import com.example.tugasakhir.Page.MainActivity;
import com.example.tugasakhir.Response.LoginResponse;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {

    private TextInputEditText email, password;
    UserManager userManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.emails);
        password = findViewById(R.id.passwords);
        userManager = new UserManager(this);

    }
    private boolean connect(){
        ConnectivityManager koneksi = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return koneksi.getActiveNetworkInfo() == null;
    }

    public void login(View view) {
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if (userEmail.isEmpty()){
            email.requestFocus();
            email.setError("Email tidak boleh kosong");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            email.requestFocus();
            email.setError("Masukkan email yang benar");
            return;
        }

        if (userPassword.isEmpty()){
            password.requestFocus();
            password.setError("Password tidak boleh kosong");
            return;
        }
        if (userPassword.length() < 4){
            password.requestFocus();
            password.setError("Password minimal 3 karakter");
            return;
        }

        if (connect()){
            Toast.makeText(this, "Tidak ada koneksi", Toast.LENGTH_SHORT).show();
        }

        Retrofit retrofit = new APIConfig().loadData();
        APIService service = retrofit.create(APIService.class);
        service.login(userEmail,userPassword).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (response.isSuccessful()){
                    Loading loading = new Loading(Login.this);
                    loading.startLoading();
                    if (loginResponse.getError().equals("200")){

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                loading.dismiss();
                                Toast.makeText(Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                                userManager.saveUser(loginResponse.getData());
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        },3000);



                    }else {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                loading.dismiss();
                                Toast.makeText(Login.this, "Email / Password salah", Toast.LENGTH_SHORT).show();
                            }
                        },3000);

                    }
                }else {
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (userManager.isLoggIn()){
            startActivity(new Intent(Login.this, Dashboard.class));
            finish();
        }
    }
}