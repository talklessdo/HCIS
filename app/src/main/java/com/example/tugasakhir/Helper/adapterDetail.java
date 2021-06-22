package com.example.tugasakhir.Helper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasakhir.Page.Sample;
import com.example.tugasakhir.R;
import com.example.tugasakhir.detail_kehadiran;

import java.util.List;

import Model.DataDetail;
import Model.DataModel;

public class adapterDetail extends RecyclerView.Adapter<adapterDetail.HolderData> {
    private Context context;
    private List<DataDetail> listData;

    public adapterDetail(Context context, List<DataDetail> listData) {
        this.context = context;
        this.listData = listData;
    }

    public adapterDetail() {

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
        View view = inflater.inflate(R.layout.card_jmlh_hadir,parent,false);

        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataDetail dm = listData.get(position);
        holder.linearDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), detail_kehadiran.class);
                intent.putExtra("idUser",dm.getId());
                intent.putExtra("nama",dm.getNama());
                v.getContext().startActivity(intent);

            }
        });



        holder.tvIdDetail.setText((dm.getId()));
        holder.tvNamaDetail.setText(dm.getNama());
        holder.tvKetDetail.setText(dm.getKet());



    }

    @Override
    public int getItemCount() {
        return (listData!=null) ? listData.size():0;
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvNamaDetail,tvIdDetail,tvKetDetail;
        LinearLayout linearDetail;


        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvNamaDetail = itemView.findViewById(R.id.tvNamaPegawai);
            linearDetail = itemView.findViewById(R.id.detail_Jmlh);
            tvKetDetail = itemView.findViewById(R.id.tv_ketPegawai);
            tvIdDetail = itemView.findViewById(R.id.tv_idPegawai);

        }
    }
}
