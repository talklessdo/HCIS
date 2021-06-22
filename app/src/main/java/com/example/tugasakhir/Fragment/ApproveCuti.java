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
import com.example.tugasakhir.Helper.adapterCuti;
import com.example.tugasakhir.Helper.adapterIzin;
import com.example.tugasakhir.R;

import java.util.List;

import Model.DataDetail;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApproveCuti extends Fragment {

    private RecyclerView rvData;
    private RecyclerView.LayoutManager lmData;
    private adapterCuti adapterCuti;
    private SwipeRefreshLayout srlData;
    private ProgressBar pbData;

    View v;
    public ApproveCuti(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.approve_cuti_fragment,container,false);
        rvData = v.findViewById(R.id.rv_ApproveCuti);
        srlData = v.findViewById(R.id.srl_dataAC);
        pbData = v.findViewById(R.id.pb_dataAC);
        lmData = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        rvData.setLayoutManager(lmData);

        adapterCuti = new adapterCuti();

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

        Call<List<DataDetail>> call = (Call<List<DataDetail>>) APIConfig.getService().ardCuti();
        call.enqueue(new Callback<List<DataDetail>>() {
            @Override
            public void onResponse(Call<List<DataDetail>> call, Response<List<DataDetail>> response) {
                List<DataDetail> list = response.body();

                adapterCuti.setList(list);
                rvData.setAdapter(adapterCuti);
                adapterCuti.notifyDataSetChanged();
                pbData.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<DataDetail>> call, Throwable t) {
                Toast.makeText(getContext(), "Tidak ada daftar cuti yang disetujui hari ini", Toast.LENGTH_SHORT).show();
                pbData.setVisibility(View.INVISIBLE);
            }
        });

    }
}