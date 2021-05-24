package com.example.tugasakhir.Helper;

import com.example.tugasakhir.Response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("logins.php")
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );
}
