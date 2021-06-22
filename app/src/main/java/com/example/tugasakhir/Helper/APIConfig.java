package com.example.tugasakhir.Helper;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConfig {


        static String URL = "https://spirituous-story.000webhostapp.com/";
        public static Retrofit loadData(){
            Gson gson = new GsonBuilder().setLenient().create();
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @NotNull
                @Override
                public Response intercept(@NotNull Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Content-Type","application/json")
                            .build();
                    return chain.proceed(request);
                }
            }).build();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
            return retrofit;
        }
        public static APIService getService() {
            APIService apiService = loadData().create(APIService.class);
            return apiService;
        }

}
