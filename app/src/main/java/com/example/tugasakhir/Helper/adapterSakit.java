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
import com.example.tugasakhir.detail_sakit;

import java.util.List;

import Model.DataDetail;
import Model.DataModel;

public class adapterSakit extends  RecyclerView.Adapter<adapterSakit.HolderData> {

    private Context context;
    private List<DataDetail> listPegawai;

    public adapterSakit(Context context, List<DataDetail> list) {
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

    public adapterSakit() {

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



//          Izin
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), detail_sakit.class);

                intent.putExtra("idUserSakit",dm.getId());
                intent.putExtra("namaSakit",dm.getNama());
                intent.putExtra("JamMasukSakit",dm.getJam_masuk());
                intent.putExtra("JamKeluarSakit",dm.getJam_keluar());
                intent.putExtra("tanggalSakit",dm.getTanggal());
                intent.putExtra("statusSakit",dm.getStatus());

                v.getContext().startActivity(intent);

            }
        });
        holder.tvId.setText((dm.getId()));
        holder.tvNama.setText((dm.getNama()));
        holder.tvKet.setText((dm.getKet()));
//        holder.tvStatus.setText(dm.getStatus());
        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return(listPegawai != null) ? listPegawai.size():0;
    }

    public static class HolderData extends RecyclerView.ViewHolder {
        DataDetail dm;
        TextView tvNama, tvAlamat, tvRoles, tvTelepon, tvId, tvName, tvKet, tvMenu;
        TextView tvJam_masuk;
        TextView tvJam_keluar, tvTanggal;
        LinearLayout linearLayout;
        LinearLayout linear;
        TextView tvNamaIzin, tvStatus, tvIdIzin;
        private Context context;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            linear = itemView.findViewById(R.id.llDetailSakit);

//            tvMenu = itemView.findViewById(R.id.tvMenu);

            //sample
            tvNama = itemView.findViewById(R.id.tvNamaSakit);
            tvKet = itemView.findViewById(R.id.tv_ketSakit);
//            tvStatus = itemView.findViewById(R.id.spin_ket);
            tvId = itemView.findViewById(R.id.tv_idSakit);



        }
    }

}