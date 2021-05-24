package com.example.tugasakhir.Response;

public class LoginResponse {
    Data data;
    String error;

    public LoginResponse(Data data, String error) {
        this.data = data;
        this.error = error;
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
}
