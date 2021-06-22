package com.example.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.tugasakhir.Helper.APIConfig;
import com.example.tugasakhir.Helper.APIService;
import com.example.tugasakhir.Helper.adapterDetailHadir;
import com.example.tugasakhir.Page.MainActivity;

import java.util.List;

import Model.DataDetail;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detail_kehadiran extends AppCompatActivity {

    private RecyclerView rvData;
    private adapterDetailHadir adapterDetailHadir;
    private List<DataDetail> list;
    private SwipeRefreshLayout srlData;
    private ProgressBar pbData;
    private Intent intent;

    private TextView TVnama,tvID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_detail_kehadiran);

        View view = getLayoutInflater().inflate(R.layout.card_detail,null);
        intent = getIntent();
        String nama = intent.getStringExtra("nama");
        tvID = findViewById(R.id.tv_idDetailHadir);
        TVnama = findViewById(R.id.tvNamaDetailHadir);
        TVnama.setText(nama);

        rvData = findViewById(R.id.rv_detailHadir);

        rvData.setLayoutManager(new LinearLayoutManager(this));

        srlData = findViewById(R.id.srl_data);
        pbData = findViewById(R.id.pb_data);
        adapterDetailHadir = new adapterDetailHadir();

        loadHadir();
        srlData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlData.setRefreshing(true);
                loadHadir();
                srlData.setRefreshing(false);
            }
        });

    }

    private void loadHadir() {

        Intent intent = getIntent();
        String idUser = intent.getStringExtra("idUser");

        pbData.setVisibility(View.VISIBLE);

        APIService arData = APIConfig.loadData().create(APIService.class);
        Call<List<DataDetail>> tampilData = arData.ardDetail(idUser);

        tampilData.enqueue(new Callback<List<DataDetail>>() {
            @Override
            public void onResponse(Call<List<DataDetail>> call, Response<List<DataDetail>> response) {
                list = response.body();
                if (list!=null) {
                    pbData.setVisibility(View.INVISIBLE);
                    adapterDetailHadir.setListData(list);
                    rvData.setAdapter(adapterDetailHadir);
                    adapterDetailHadir.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<List<DataDetail>> call, Throwable t) {
                Toast.makeText(detail_kehadiran.this, "Belum Hadir", Toast.LENGTH_SHORT).show();
                pbData.setVisibility(View.INVISIBLE);

            }

        });





    }

    public void back (View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}