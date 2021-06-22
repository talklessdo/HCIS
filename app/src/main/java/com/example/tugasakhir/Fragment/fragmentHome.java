package com.example.tugasakhir.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.tugasakhir.Helper.APIConfig;
import com.example.tugasakhir.Helper.APIService;
import com.example.tugasakhir.Helper.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugasakhir.Page.Profile;
import com.example.tugasakhir.R;
import com.example.tugasakhir.Response.JumlahResponse;
import com.example.tugasakhir.cuti_today;
import com.example.tugasakhir.hadir_today;
import com.example.tugasakhir.izin_today;
import com.example.tugasakhir.sakit_today;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentHome extends Fragment {

    private CardView list_sakit,list_hadir,list_izin,list_cuti;
    private TextView jml_hadir, jml_user,jml_sakit,jml_userSakit,
            jml_cuti,jml_userCuti,jml_izin,jml_userIzin,userName;
    private String jmlHadir,jmlUser;
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
        jml_hadir = v.findViewById(R.id.jmlHadir);
        jml_cuti = v.findViewById(R.id.jmlCuti);
        jml_izin = v.findViewById(R.id.jmlIzin);
        jml_sakit = v.findViewById(R.id.jmlSakit);

        jml_user = v.findViewById(R.id.jmlUser);
        jml_userCuti = v.findViewById(R.id.jmlUserCuti);
        jml_userSakit = v.findViewById(R.id.jmlUserSakit);
        jml_userIzin = v.findViewById(R.id.jmlUserIzin);

        list_hadir = v.findViewById(R.id.card_hadir);
        list_sakit = v.findViewById(R.id.card_sakit);
        list_izin = v.findViewById(R.id.card_izin);
        list_cuti = v.findViewById(R.id.card_cuti);

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

        getJmlHadir();
        getJmlSakit();
        getJmlCuti();
        getJmlIzin();
        getJmlUser();
        return v;
    }

    private void getJmlIzin() {
        Retrofit retrofit = new APIConfig().loadData();
        APIService service = retrofit.create(APIService.class);
        service.showIzin().enqueue(new Callback<JumlahResponse>() {
            @Override
            public void onResponse(Call<JumlahResponse> call, Response<JumlahResponse> response) {
                JumlahResponse jumlahResponse = response.body();
                if (response.isSuccessful()){
                    if (jumlahResponse.getJumlah() != null){
                        jmlHadir = jumlahResponse.getJumlah();
                        jml_izin.setText(jmlHadir+"/");
                    }

                }else {
                    Toast.makeText(getContext(), "gagal" + response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JumlahResponse> call, Throwable t) {

            }
        });
    }

    private void getJmlCuti() {
        Retrofit retrofit = new APIConfig().loadData();
        APIService service = retrofit.create(APIService.class);
        service.showCuti().enqueue(new Callback<JumlahResponse>() {
            @Override
            public void onResponse(Call<JumlahResponse> call, Response<JumlahResponse> response) {
                JumlahResponse jumlahResponse = response.body();
                if (response.isSuccessful()){
                    if (jumlahResponse.getJumlah() != null){
                        jmlHadir = jumlahResponse.getJumlah();
                        jml_cuti.setText(jmlHadir+"/");
                    }
                }else {
                    Toast.makeText(getContext(), "gagal" + response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JumlahResponse> call, Throwable t) {

            }
        });
    }

    private void getJmlSakit() {
        Retrofit retrofit = new APIConfig().loadData();
        APIService service = retrofit.create(APIService.class);
        service.showSakit().enqueue(new Callback<JumlahResponse>() {
            @Override
            public void onResponse(Call<JumlahResponse> call, Response<JumlahResponse> response) {
                JumlahResponse jumlahResponse = response.body();
                if (response.isSuccessful()){
                    if (jumlahResponse.getJumlah() != null){
                        jmlHadir = jumlahResponse.getJumlah();
                        jml_sakit.setText(jmlHadir+"/");
                    }
                }else {
                    Toast.makeText(getContext(), "gagal" + response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JumlahResponse> call, Throwable t) {

            }
        });
    }

    private void getJmlHadir() {
        Retrofit retrofit = new APIConfig().loadData();
        APIService service = retrofit.create(APIService.class);
        service.showHadir().enqueue(new Callback<JumlahResponse>() {
            @Override
            public void onResponse(Call<JumlahResponse> call, Response<JumlahResponse> response) {
                JumlahResponse jumlahResponse = response.body();
                if (response.isSuccessful()){
                    if (jumlahResponse.getJumlah() != null){
                        jmlHadir = jumlahResponse.getJumlah();
                        jml_hadir.setText(jmlHadir+"/");
                    }
                }else {
                    Toast.makeText(getContext(), "gagal" + response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JumlahResponse> call, Throwable t) {

            }
        });
    }

    private void getJmlUser() {
        Retrofit retrofit = new APIConfig().loadData();
        APIService service = retrofit.create(APIService.class);
        service.showUser().enqueue(new Callback<JumlahResponse>() {
            @Override
            public void onResponse(Call<JumlahResponse> call, Response<JumlahResponse> response) {
                JumlahResponse jumlahResponse = response.body();
                if (response.isSuccessful()){
                    if (jumlahResponse.getJumlah() != null){
                        jmlUser = jumlahResponse.getJumlah();
                        jml_user.setText(jmlUser);
                        jml_userCuti.setText(jmlUser);
                        jml_userSakit.setText(jmlUser);
                        jml_userIzin.setText(jmlUser);
                    }
                }else {
                    Toast.makeText(getContext(), "gagal" + response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JumlahResponse> call, Throwable t) {

            }
        });
    }

}