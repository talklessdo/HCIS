package com.example.tugasakhir.Helper;

import com.example.tugasakhir.Response.Data;
import com.example.tugasakhir.Response.JumlahResponse;
import com.example.tugasakhir.Response.LoginResponse;

import java.util.Date;
import java.util.List;

import Model.DataDetail;
import Model.DataModel;
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

//    Jumlah
    @GET("admin/show_hadir_today.php")
    Call<JumlahResponse> showHadir();

    @GET("admin/show_sakit_today.php")
    Call<JumlahResponse> showSakit();

    @GET("admin/show_cuti_today.php")
    Call<JumlahResponse> showCuti();

    @GET("admin/show_izin_today.php")
    Call<JumlahResponse> showIzin();

    @GET("admin/show_jml_user.php")
    Call<JumlahResponse> showUser();


    @GET("show.php")
    Call <ResponseModel> ardShowaData();

    @GET("admin/user.php")
    Call <List<DataDetail>> ardUser();

    @FormUrlEncoded
    @POST("admin/detailHadir.php")
    Call<List<DataDetail>> ardDetail(
            @Field("id") String id

    );

    @FormUrlEncoded
    @POST("admin/detailSakit.php")
    Call<List<DataDetail>> ardDetailSakit(
            @Field("id") String id

    );

    @GET("admin/hdr_today.php")
    Call <List<DataDetail>> ardHdrToday();

//    API Sakit
    @GET("admin/waitsakit.php")
    Call <List<DataDetail>> ardWaitSakit();

    @GET("admin/tolaksakit.php")
    Call <List<DataDetail>> ardTolakSakit();

    @GET("admin/sakit.php")
    Call <List<DataDetail>> ardSakit();

//    API Izin
    @GET("admin/waitizin.php")
    Call <List<DataDetail>> ardWaitIzin();

    @GET("admin/tolakizin.php")
    Call <List<DataDetail>> ardTolakIzin();

    @GET("admin/izin.php")
    Call <List<DataDetail>> ardIzin();

    //    API Cuti
    @GET("admin/waitcuti.php")
    Call <List<DataDetail>> ardWaitCuti();

    @GET("admin/tolakcuti.php")
    Call <List<DataDetail>> ardTolakCuti();

    @GET("admin/cuti.php")
    Call <List<DataDetail>> ardCuti();

    @FormUrlEncoded
    @POST("admin/update.php")
    Call<LoginResponse> ardUpdate(
            @Field("id") String id,
            @Field("status") String status

    );

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
