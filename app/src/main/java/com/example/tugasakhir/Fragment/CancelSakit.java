package com.example.tugasakhir.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tugasakhir.Helper.APIConfig;
import com.example.tugasakhir.Helper.adapterSakit;
import com.example.tugasakhir.R;

import java.util.List;

import Model.DataDetail;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CancelSakit extends Fragment {

    private RecyclerView rvData;
    private RecyclerView.LayoutManager lmData;
    private adapterSakit adapterSakit;
    private SwipeRefreshLayout srlData;
    private ProgressBar pbData;

    View v;
    public CancelSakit(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.cancel_sakit_fragment,container,false);
        rvData = v.findViewById(R.id.rv_CancelSakit);
        srlData = v.findViewById(R.id.srl_dataCS);
        pbData = v.findViewById(R.id.pb_dataCS);
        lmData = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        rvData.setLayoutManager(lmData);

        adapterSakit = new adapterSakit();

        load();

        srlData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlData.setRefreshing(true);
                load();
                srlData.setRefreshing(false);
            }
        });



        return v;
    }



    private void load() {
        pbData.setVisibility(View.VISIBLE);

        Call<List<DataDetail>> call = (Call<List<DataDetail>>) APIConfig.getService().ardTolakSakit();
        call.enqueue(new Callback<List<DataDetail>>() {
            @Override
            public void onResponse(Call<List<DataDetail>> call, Response<List<DataDetail>> response) {
                List<DataDetail> list = response.body();

                adapterSakit.setList(list);
                rvData.setAdapter(adapterSakit);
                adapterSakit.notifyDataSetChanged();
                pbData.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<DataDetail>> call, Throwable t) {
                Toast.makeText(getContext(), "Tidak ada daftar sakit yang ditolak hari ini", Toast.LENGTH_SHORT).show();
                pbData.setVisibility(View.INVISIBLE);
            }
        });

    }
}