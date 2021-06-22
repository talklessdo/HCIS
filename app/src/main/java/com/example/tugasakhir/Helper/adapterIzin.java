package com.example.tugasakhir.Helper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasakhir.R;
import com.example.tugasakhir.detail_izin;
import com.example.tugasakhir.detail_sakit;

import java.util.List;

import Model.DataDetail;

public class adapterIzin extends  RecyclerView.Adapter<adapterIzin.HolderData> {

    private Context context;
    private List<DataDetail> listPegawai;

    public adapterIzin(Context context, List<DataDetail> list) {
        this.context = context;
        this.listPegawai = list;
    }

    public Context getContext() {
        return context;
    }

    public List<DataDetail> getList() {
        return listPegawai;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setList(List<DataDetail> list) {
        this.listPegawai = list;
    }

    public adapterIzin() {

    }



    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_sakit,parent,false);

        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataDetail dm = listPegawai.get(position);

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), detail_izin.class);

                intent.putExtra("idUserIzin",dm.getId());
                intent.putExtra("namaIzin",dm.getNama());
                intent.putExtra("JamMasukIzin",dm.getJam_masuk());
                intent.putExtra("JamKeluarIzin",dm.getJam_keluar());
                intent.putExtra("tanggalIzin",dm.getTanggal());
                intent.putExtra("statusIzin",dm.getStatus());

                v.getContext().startActivity(intent);

            }
        });
        holder.tvId.setText((dm.getId()));
        holder.tvNama.setText((dm.getNama()));
        holder.tvKet.setText((dm.getKet()));
        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return(listPegawai != null) ? listPegawai.size():0;
    }

    public static class HolderData extends RecyclerView.ViewHolder {
        DataDetail dm;
        TextView tvNama, tvId, tvKet;
        LinearLayout linear;
        public HolderData(@NonNull View itemView) {
            super(itemView);
            linear = itemView.findViewById(R.id.llDetailSakit);

            tvNama = itemView.findViewById(R.id.tvNamaSakit);
            tvKet = itemView.findViewById(R.id.tv_ketSakit);
            tvId = itemView.findViewById(R.id.tv_idSakit);



        }
    }

}