package com.example.tugasakhir.Helper;

import com.example.tugasakhir.Response.Data;
import com.example.tugasakhir.Response.LoginResponse;

import java.util.Date;

import Model.ResponseModel;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("logins.php")
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("show.php")
    Call <ResponseModel> ardShowaData();

    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseModel> CreateData(
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("password") String password,
            @Field("tgl_lahir") String tgl_lahir,
            @Field("alamat") String alamat,
            @Field("telepon") String telepon,
            @Field("gender") String gender,
            @Field("agama") String agama,
            @Field("roles") String roles
    );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseModel> DeleteData(
            @Field("id") Integer id
    );

    @FormUrlEncoded
    @POST("detail.php")
    Call<ResponseModel> DetailData(
            @Field("id") Integer id
    );

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseModel> UpdateData(
            @Field("id") Integer id,
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("password") String password,
            @Field("tgl_lahir") String tgl_lahir,
            @Field("alamat") String alamat,
            @Field("telepon") String telepon,
            @Field("gender") String gender,
            @Field("agama") String agama,
            @Field("roles") String roles
    );

    @FormUrlEncoded
    @POST("ChangePass.php")
    Call<ResponseModel> UpdatePass(
            @Field("id") String id,
            @Field("password") String password

    );

}
