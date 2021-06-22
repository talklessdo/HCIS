package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugasakhir.Helper.APIConfig;
import com.example.tugasakhir.Helper.APIService;
import com.example.tugasakhir.Page.MainActivity;
import com.example.tugasakhir.Response.LoginResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detail_sakit extends AppCompatActivity {

    TextView TVnama;
    TextView TVjam_masuk;
    TextView TVjam_keluar;
    TextView TVtanggal;
    TextView TVtanggal2;
    TextView tvStatus;
    TextView tvID, KetStatus;
    Spinner spinKeterangan;
    Bundle bundle;
    Button btnSetuju;
    Button btnBatal;
    int pilih;
    List<String> status = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sakit);

        tvID = findViewById(R.id.tv_id_hadir);
        btnSetuju = findViewById(R.id.btn_update);
        btnBatal = findViewById(R.id.btn_cancel);
        spinKeterangan = findViewById(R.id.spin_ket);
        KetStatus = findViewById(R.id.keterangan);
        TVnama = findViewById(R.id.tvNamaDetail);
        TVjam_masuk = findViewById(R.id.tvJam_masukHadir);
        TVjam_keluar = findViewById(R.id.tvJam_keluarHadir);
        TVtanggal = findViewById(R.id.tvTanggalHadir1);
        TVtanggal2 = findViewById(R.id.tvTanggalHadir2);
        tvStatus = findViewById(R.id.tvStatus);



// cek apakah ada bundle atau tidak
        if (getIntent().getExtras() != null) {

            //jika bundle ada, ambil data dari bundle
            bundle = getIntent().getExtras();

            tvID.setText(bundle.getString("idUserSakit"));
            TVnama.setText(bundle.getString("namaSakit"));
            TVjam_masuk.setText(bundle.getString("JamMasukSakit"));
            TVjam_keluar.setText(bundle.getString("JamKeluarSakit"));
            TVtanggal.setText(bundle.getString("tanggalSakit"));
            TVtanggal2.setText(bundle.getString("tanggalSakit"));
            tvStatus.setText(bundle.getString("statusSakit"));
            String statusData = bundle.getString("statusSakit");

            if (statusData.equals("menunggu")) {
                tvStatus.setTextColor(getResources().getColor(R.color.yellow));
                status.add(0,"Pilih Persetujuan");
                status.add("Disetujui");
                status.add("Ditolak");

            }else if (statusData.equals("ditolak")) {
                tvStatus.setTextColor(getResources().getColor(R.color.red));
                status.add(0,"Pilih Persetujuan");
                status.add("Menunggu");
                status.add("Disetujui");

            }else {
                tvStatus.setTextColor(getResources().getColor(R.color.green));
                status.add(0,"Pilih Persetujuan");
                status.add("Menunggu");
                status.add("Ditolak");
            }

        } else {
            // apabila bundle tidak ada maka ambil dari intent
            tvID.setText(bundle.getString("idUserSakit"));
            TVnama.setText(getIntent().getStringExtra("namaSakit"));
            TVjam_masuk.setText(getIntent().getStringExtra("JamMasukSakit"));
            TVjam_keluar.setText(getIntent().getStringExtra("JamKeluarSakit"));
            TVtanggal.setText(getIntent().getStringExtra("tanggalSakit"));
            TVtanggal2.setText(getIntent().getStringExtra("tanggalSakit"));
            tvStatus.setText(bundle.getString("status"));
        }

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,status);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinKeterangan.setAdapter(dataAdapter);

        //spinner hidden item

        spinKeterangan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pilih = position;
                if (parent.getItemAtPosition(position).equals("Pilih Persetujuan")) {
                    //bila pilih perizinan
                    String item = parent.getSelectedItem().toString();
                    Toast.makeText(detail_sakit.this, "Pilih Tindakan", Toast.LENGTH_SHORT).show();

                }else {
                    String pilihanKet = spinKeterangan.getSelectedItem().toString();
                    KetStatus.setText(pilihanKet);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO Auto-generated method stub
            }
        });

        btnSetuju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pilih == 0){
                    Toast.makeText(detail_sakit.this, "Harap Pilih Tindakan", Toast.LENGTH_SHORT).show();
                }else {

                    approve();
                    finish();
                }
            }
        });

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    private void approve(){

        String idUser = tvID.getText().toString();
        String status = KetStatus.getText().toString();

        APIService api = APIConfig.loadData().create(APIService.class);
        Call<LoginResponse> update = api.ardUpdate(idUser,status);
        update.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Toast.makeText(detail_sakit.this, "Berhasil "+status, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("Retro","OnFailure");

            }
        });
    }

    public void back (View view){
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
        finish();
    }
}