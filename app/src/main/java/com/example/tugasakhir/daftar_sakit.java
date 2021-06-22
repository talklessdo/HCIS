package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tugasakhir.Fragment.fragmentHome;
import com.example.tugasakhir.Helper.APIConfig;
import com.example.tugasakhir.Helper.adapterDetail;

import java.util.List;

import Model.DataDetail;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class daftar_sakit extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.LayoutManager lmData;
    private adapterDetail adapterDetail;
    private SwipeRefreshLayout srlData;
    private ProgressBar pbData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_keterangan);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvData = findViewById(R.id.rv_dataHadirPegawai);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rvData.setLayoutManager(lmData);

        srlData = findViewById(R.id.srl_data);
        pbData = findViewById(R.id.pb_data);
        adapterDetail = new adapterDetail();

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

        Call<List<DataDetail>> call =  APIConfig.getService().ardUser();
        call.enqueue(new Callback<List<DataDetail>>() {
            @Override
            public void onResponse(Call<List<DataDetail>> call, Response<List<DataDetail>> response) {
                if (response.isSuccessful()) {
                    List<DataDetail> list = response.body();
                    adapterDetail.setListData(list);
                    rvData.setAdapter(adapterDetail);

                }


                pbData.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<DataDetail>> call, Throwable t) {
                Toast.makeText(daftar_sakit.this, "Gagal, Tidak ada data", Toast.LENGTH_SHORT).show();
                pbData.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void back(View view) {
        Intent intent = new Intent(this, fragmentHome.class);
    }
}
