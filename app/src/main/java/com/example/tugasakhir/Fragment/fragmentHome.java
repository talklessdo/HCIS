package com.example.tugasakhir.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.tugasakhir.Helper.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tugasakhir.R;
import com.example.tugasakhir.cuti_today;
import com.example.tugasakhir.hadir_today;
import com.example.tugasakhir.izin_today;
import com.example.tugasakhir.sakit_today;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentHome extends Fragment {

    CardView list_sakit;
    CardView list_hadir;
    CardView list_izin;
    CardView list_cuti;
    TextView userName;
    Button btnHadir;
    // Required empty public constructor
    UserManager userManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentHome() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentHome newInstance(String param1, String param2) {
        fragmentHome fragment = new fragmentHome();
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
        View v = inflater.inflate(R.layout.fragment_home,container,false);
        list_hadir = v.findViewById(R.id.card_hadir);
        list_sakit = v.findViewById(R.id.card_sakit);
        list_izin = v.findViewById(R.id.card_izin);
        list_cuti = v.findViewById(R.id.card_cuti);
        btnHadir = v.findViewById(R.id.rekam_kehadiran);

        userManager = new UserManager(getContext());
        userName = v.findViewById(R.id.name);

        userName.setText(userManager.getData().getNama());

        list_hadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), hadir_today.class));
            }
        });

        list_sakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), sakit_today.class));
            }
        });

        list_cuti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), cuti_today.class));
            }
        });

        list_izin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), izin_today.class));
            }
        });

        btnHadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), hadir_today.class));
            }
        });

        return v;
    }
}