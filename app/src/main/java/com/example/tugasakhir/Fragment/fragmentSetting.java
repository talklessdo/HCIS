package com.example.tugasakhir.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.tugasakhir.ComproActivity;
import com.example.tugasakhir.Helper.PegawaiManager;
import com.example.tugasakhir.Helper.UserManager;
import com.example.tugasakhir.NotifikasiActivity;
import com.example.tugasakhir.PasswordActivity;
import com.example.tugasakhir.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentSetting#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentSetting extends Fragment {

    Switch myswitch;
    TextView myRoles, myPass, myEditPass, myAbout, myAlat;
    UserManager userManager;
    private RecyclerView.Adapter adData;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentSetting() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentSetting.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentSetting newInstance(String param1, String param2) {
        fragmentSetting fragment = new fragmentSetting();
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
       View v =  inflater.inflate(R.layout.fragment_setting, container, false);

        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES)
        {
            getActivity().setTheme(R.style.darktheme);
        } else {
            getActivity().setTheme(R.style.AppTheme);
        }
        myswitch = v.findViewById(R.id.switchh);
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES)
        {
            myswitch.setChecked(true);
        }

        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                }
            }
        });

       myRoles = v.findViewById(R.id.roles);
       myPass = v.findViewById(R.id.password);
       myEditPass = v.findViewById(R.id.etPass);
       myAbout = v.findViewById(R.id.tentang);
       myAlat = v.findViewById(R.id.notifAbsen);

       myAlat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), NotifikasiActivity.class);
               startActivity(intent);
           }
       });

       userManager = new UserManager(getContext());

       myRoles.setText(userManager.getData().getRoles());
       myPass.setText(userManager.getData().getPassword());

       myEditPass.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), PasswordActivity.class);
               startActivity(intent);
           }
       });

       myAbout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), ComproActivity.class);
               startActivity(intent);
           }
       });

       return  v;
    }
}