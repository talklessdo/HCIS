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
import com.example.tugasakhir.detail_cuti;
import com.example.tugasakhir.detail_izin;

import java.util.List;

import Model.DataDetail;

public class adapterCuti extends  RecyclerView.Adapter<adapterCuti.HolderData> {

    private Context context;
    private List<DataDetail> listPegawai;

    public adapterCuti(Context context, List<DataDetail> list) {
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

    public adapterCuti() {

    }



    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_cuti,parent,false);

        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataDetail dm = listPegawai.get(position);

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), detail_cuti.class);

                intent.putExtra("idUserCuti",dm.getId());
                intent.putExtra("namaCuti",dm.getNama());
                intent.putExtra("JamMasukCuti",dm.getJam_masuk());
                intent.putExtra("JamKeluarCuti",dm.getJam_keluar());
                intent.putExtra("tanggalCuti",dm.getTanggal());
                intent.putExtra("statusCuti",dm.getStatus());

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
            linear = itemView.findViewById(R.id.llDetailCuti);

            tvNama = itemView.findViewById(R.id.tvNamaCuti);
            tvKet = itemView.findViewById(R.id.tv_ketCuti);
            tvId = itemView.findViewById(R.id.tv_idCuti);



        }
    }

}