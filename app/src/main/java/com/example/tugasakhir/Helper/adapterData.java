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

import com.example.tugasakhir.Page.Hadir;
import com.example.tugasakhir.R;

import java.util.List;

import Model.DataDetail;
import Model.DataModel;

public class adapterData extends RecyclerView.Adapter<adapterData.HolderData>{

    private Context context;
    private List<DataDetail> listData;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setListData(List<DataDetail> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_hadir,parent,false);

        return new HolderData(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataDetail dm = listData.get(position);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Hadir.class);

                intent.putExtra("idUser",dm.getId());
                intent.putExtra("nama",dm.getNama());
                intent.putExtra("JamMasuk",dm.getJam_masuk());
                intent.putExtra("JamKeluar",dm.getJam_keluar());
                intent.putExtra("tanggal",dm.getTanggal());
                intent.putExtra("keterangan",dm.getKet());

                v.getContext().startActivity(intent);

            }
        });

        holder.tvId.setText((dm.getId()));
        holder.tvNama.setText(dm.getNama());
//        holder.tvKet.setText(dm.getKeterangan());




    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder {
        TextView tvNama, tvId, tvKet;
        LinearLayout linearLayout;
        LinearLayout linearDetail;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.detail_hadir);
            linearDetail = itemView.findViewById(R.id.detail_kehadiranPegawai);
            tvNama = itemView.findViewById(R.id.tvNamaHadir);

            tvKet = itemView.findViewById(R.id.tv_ketHadir);
            tvId = itemView.findViewById(R.id.tv_idHadir);




        }
    }


}
