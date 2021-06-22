package com.example.tugasakhir.Response;

import java.sql.Time;
import java.util.List;

import Model.DataModel;

public class LoginResponse {
    Data data;
    String error;
    private Time jam_masuk, jam_keluar;
    private String ket, status;

    public LoginResponse(Data data, String error, Time jam_masuk, Time jam_keluar, String ket, String status) {
        this.data = data;
        this.error = error;
        this.jam_masuk = jam_masuk;
        this.jam_keluar = jam_keluar;
        this.ket = ket;
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Time getJam_masuk() {
        return jam_masuk;
    }

    public void setJam_masuk(Time jam_masuk) {
        this.jam_masuk = jam_masuk;
    }

    public Time getJam_keluar() {
        return jam_keluar;
    }

    public void setJam_keluar(Time jam_keluar) {
        this.jam_keluar = jam_keluar;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
