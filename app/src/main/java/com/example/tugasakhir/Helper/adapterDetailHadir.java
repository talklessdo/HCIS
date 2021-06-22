package com.example.tugasakhir.Helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasakhir.R;
import com.example.tugasakhir.detail_kehadiran;

import java.util.List;

import Model.DataDetail;
import Model.DataModel;

public class adapterDetailHadir extends RecyclerView.Adapter<adapterDetailHadir.HolderData>{
    private Context context;
    private List<DataDetail> listData;


    public adapterDetailHadir(Context context, List<DataDetail> listData) {
        this.context = context;
        this.listData = listData;
    }

    public adapterDetailHadir() {

    }

    public adapterDetailHadir(detail_kehadiran context, DataDetail list) {

    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<DataDetail> getListData() {
        return listData;
    }

    public void setListData(List<DataDetail> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_detail,parent,false);

        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataDetail dm = listData.get(position);
        holder.tvIdDetailHdr.setText(dm.getId());
        holder.tvJamMasuk.setText(dm.getJam_masuk());
        holder.tvJamKeluar.setText(dm.getJam_keluar());
        holder.tvTanggal1.setText(dm.getTanggal());
        holder.tvTanggal2.setText(dm.getTanggal());
        if (dm.getLembur() == null){
            holder.lembur.setText("-");
        }else {
            holder.lembur.setText(dm.getLembur());
        }

        if (dm.getProduksi() == null){
            holder.produksi.setText("-");
        }else {
            holder.produksi.setText(dm.getProduksi());
        }
    }

    @Override
    public int getItemCount() {
        return (listData!=null) ? listData.size():0;

    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvIdDetailHdr, tvJamMasuk,tvJamKeluar, tvTanggal1,tvTanggal2,lembur,produksi;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvIdDetailHdr = itemView.findViewById(R.id.idDetailHdr);
            tvJamMasuk = itemView.findViewById(R.id.tvJam_masukDetailHadir);
            lembur = itemView.findViewById(R.id.tvLembur);
            produksi = itemView.findViewById(R.id.tvProduksi);
            tvJamKeluar = itemView.findViewById(R.id.tvJam_keluarDetailHadir);
            tvTanggal1 = itemView.findViewById(R.id.tvTanggalDetailHadir1);
            tvTanggal2 = itemView.findViewById(R.id.tvTanggalDetailHadir2);


        }
    }
}
