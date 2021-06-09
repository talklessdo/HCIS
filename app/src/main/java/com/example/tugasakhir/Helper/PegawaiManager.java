package com.example.tugasakhir.Helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasakhir.DetailActivity;
import com.example.tugasakhir.Login;
import com.example.tugasakhir.MainActivity;
import com.example.tugasakhir.R;
import com.example.tugasakhir.Response.Data;
import com.example.tugasakhir.UpdateActivity;
import com.example.tugasakhir.daftar_pegawai;
import com.example.tugasakhir.tambahPegawai;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import Model.DataModel;
import Model.ResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PegawaiManager extends RecyclerView.Adapter<PegawaiManager.HolderData> {
    private Context ctx;
    private List<DataModel> listData;
    private List<DataModel> listPegawai;
    private Integer idPegawai;

    public PegawaiManager(Context ctx, List<DataModel> listData) {
        this.ctx = ctx;
        this.listData = listData;
    }


    @NonNull
    @NotNull
    @Override
    public HolderData onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View layaout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HolderData holder = new HolderData(layaout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HolderData holder, int position) {
        DataModel dm = listData.get(position);

        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvNama.setText(dm.getNama());
        holder.tvRoles.setText(dm.getRoles());
        holder.tvAlamat.setText(dm.getAlamat());


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvNama, tvRoles, tvAlamat, tvId;
        ImageView edit, delete;

        public HolderData(@NonNull @NotNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvRoles = itemView.findViewById(R.id.tv_roles);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvId = itemView.findViewById(R.id.tv_ID);
            edit = itemView.findViewById(R.id.ImgEdit);
            delete = itemView.findViewById(R.id.ImgDelete);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idPegawai = Integer.parseInt(tvId.getText().toString());
                    APIService ardData = APIConfig.loadData().create(APIService.class);
                    Call<ResponseModel> detailData = ardData.DetailData(idPegawai);

                    detailData.enqueue(new Callback<ResponseModel>() {
                        @Override
                        public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                            int kode = response.body().getKode();
                            String pesan = response.body().getPesan();
                            listPegawai = response.body().getData();

                            Integer varIdPegawai = listPegawai.get(0).getId();
                            String varNamaPegawai = listPegawai.get(0).getNama();
                            String varEmailPegawai = listPegawai.get(0).getEmail();
                            String varPassPegawai = listPegawai.get(0).getPassword();
                            String varTtlPegawai = listPegawai.get(0).getTgl_lahir();
                            String varAlamatPegawai = listPegawai.get(0).getAlamat();
                            String varHpPegawai = listPegawai.get(0).getTelepon();
                            String varGenderPegawai = listPegawai.get(0).getGender();
                            String varAgamaPegawai = listPegawai.get(0).getAgama();
                            String varRolesPegawai = listPegawai.get(0).getRoles();

                            Intent intent = new Intent(ctx, DetailActivity.class);
                            intent.putExtra("xId", varIdPegawai);
                            intent.putExtra("xNama", varNamaPegawai);
                            intent.putExtra("xEmail", varEmailPegawai);
                            intent.putExtra("xPass", varPassPegawai);
                            intent.putExtra("xTgl_lahir", varTtlPegawai);
                            intent.putExtra("xAlamat", varAlamatPegawai);
                            intent.putExtra("xHp", varHpPegawai);
                            intent.putExtra("xGender", varGenderPegawai);
                            intent.putExtra("xAgama", varAgamaPegawai);
                            intent.putExtra("xRoles", varRolesPegawai);
                            ctx.startActivity(intent);

                            Toast.makeText(ctx, "Kode : " + kode + " | Pesan : " + pesan + " id " + varIdPegawai, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<ResponseModel> call, Throwable t) {
                            Toast.makeText(ctx, "Gagal Menghubungi Server " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            });

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idPegawai = Integer.parseInt(tvId.getText().toString());
                    APIService ardData = APIConfig.loadData().create(APIService.class);
                    Call<ResponseModel> ambilData = ardData.DetailData(idPegawai);

                    ambilData.enqueue(new Callback<ResponseModel>() {
                        @Override
                        public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                            int kode = response.body().getKode();
                            String pesan = response.body().getPesan();
                            listPegawai = response.body().getData();

                            Integer varIdPegawai = listPegawai.get(0).getId();
                            String varNamaPegawai = listPegawai.get(0).getNama();
                            String varEmailPegawai = listPegawai.get(0).getEmail();
                            String varPassPegawai = listPegawai.get(0).getPassword();
                            String varTtlPegawai = listPegawai.get(0).getTgl_lahir();
                            String varAlamatPegawai = listPegawai.get(0).getAlamat();
                            String varHpPegawai = listPegawai.get(0).getTelepon();
                            String varGenderPegawai = listPegawai.get(0).getGender();
                            String varAgamaPegawai = listPegawai.get(0).getAgama();
                            String varRolesPegawai = listPegawai.get(0).getRoles();

                            Intent intent = new Intent(ctx, UpdateActivity.class);
                            intent.putExtra("xId", varIdPegawai);
                            intent.putExtra("xNama", varNamaPegawai);
                            intent.putExtra("xEmail", varEmailPegawai);
                            intent.putExtra("xPass", varPassPegawai);
                            intent.putExtra("xTgl_lahir", varTtlPegawai);
                            intent.putExtra("xAlamat", varAlamatPegawai);
                            intent.putExtra("xHp", varHpPegawai);
                            intent.putExtra("xGender", varGenderPegawai);
                            intent.putExtra("xAgama", varAgamaPegawai);
                            intent.putExtra("xRoles", varRolesPegawai);
                            ctx.startActivity(intent);

                            Toast.makeText(ctx, "Kode : " + kode + " | Pesan : " + pesan + " id " + varIdPegawai, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<ResponseModel> call, Throwable t) {
                            Toast.makeText(ctx, "Gagal Menghubungi Server " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PilihanHapus();
                }

                private void PilihanHapus() {
                    idPegawai = Integer.parseInt(tvId.getText().toString());

                    AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                    builder.setTitle("Yakin Akan Meghapus Data?");
                    builder.setIcon(R.drawable.ic_delete);
                    builder.setMessage("Pilih oke jika yakin untuk menghapus data");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deleteData();
                            dialog.dismiss();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    ((daftar_pegawai) ctx).retrieveData();
                                }
                            },800);
                        }

                        private void deleteData() {
                            APIService ardData = APIConfig.loadData().create(APIService.class);
                            Call <ResponseModel> hapusData = ardData.DeleteData(idPegawai);

                            hapusData.enqueue(new Callback<ResponseModel>() {
                                @Override
                                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                                    int kode = response.body().getKode();
                                    String pesan = response.body().getPesan();

                                    Toast.makeText(ctx, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(Call<ResponseModel> call, Throwable t) {
//                                    Toast.makeText(ctx, "Gagal Menghubungi Server "+ t.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                    builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();
                }
            });
        }
    }
}
