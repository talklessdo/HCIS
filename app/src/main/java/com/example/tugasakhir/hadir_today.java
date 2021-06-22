package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tugasakhir.Helper.APIConfig;
import com.example.tugasakhir.Helper.adapterData;
import com.example.tugasakhir.Page.MainActivity;

import java.util.List;

import Model.DataDetail;
import Model.DataModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class hadir_today extends AppCompatActivity {

    private RecyclerView rvData;
    private RecyclerView.LayoutManager lmData;
    private com.example.tugasakhir.Helper.adapterData adapterData;
    private SwipeRefreshLayout srlData;
    private ProgressBar pbData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadir_today);


        rvData = findViewById(R.id.rv_dataHadir);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rvData.setLayoutManager(lmData);

        srlData = findViewById(R.id.srl_data);
        pbData = findViewById(R.id.pb_data);
        adapterData = new adapterData();


        load();
        srlData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlData.setRefreshing(true);
                load();
                srlData.setRefreshing(false);
            }
        });

    }

    private void load() {
        pbData.setVisibility(View.VISIBLE);

        Call<List<DataDetail>> call =  APIConfig.getService().ardHdrToday();
        call.enqueue(new Callback<List<DataDetail>>() {
            @Override
            public void onResponse(Call<List<DataDetail>> call, Response<List<DataDetail>> response) {
            List<DataDetail> list = response.body();
            if (response.isSuccessful()) {
                    adapterData.setListData(list);
                    rvData.setAdapter(adapterData);
                }
                pbData.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<DataDetail>> call, Throwable t) {
                Toast.makeText(hadir_today.this, "Belum ada yang hadir", Toast.LENGTH_SHORT).show();
                pbData.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void back(View view) {
        Intent intent = new Intent(hadir_today.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}