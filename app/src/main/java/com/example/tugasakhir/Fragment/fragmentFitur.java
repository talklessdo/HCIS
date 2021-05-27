package com.example.tugasakhir.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tugasakhir.MainActivity;
import com.example.tugasakhir.R;
import com.example.tugasakhir.daftar_cuti;
import com.example.tugasakhir.daftar_divisi;
import com.example.tugasakhir.daftar_kehadiran;
import com.example.tugasakhir.daftar_pegawai;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentFitur#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentFitur extends Fragment {

    CardView divisi;
    CardView pegawai;
    CardView cuti;
    CardView hadir;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Object CardView;

    public fragmentFitur() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentFitur.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentFitur newInstance(String param1, String param2) {
        fragmentFitur fragment = new fragmentFitur();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fitur,container,false);
        pegawai = v.findViewById(R.id.dftr_pegawai);
        cuti = v.findViewById(R.id.dftr_cuti);
        divisi = v.findViewById(R.id.dftr_divisi);
        hadir = v.findViewById(R.id.dftr_hadir);

        pegawai.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               startActivity(new Intent(getActivity(),daftar_pegawai.class));

            }
        });

        cuti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), daftar_cuti.class));
            }
        });

        hadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), daftar_kehadiran.class));
            }
        });

        divisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), daftar_divisi.class));
            }
        });




        return v;





    }
}