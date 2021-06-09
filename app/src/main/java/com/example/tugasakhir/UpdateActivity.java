package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugasakhir.Helper.APIConfig;
import com.example.tugasakhir.Helper.APIService;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import Model.ResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {

    private int xid;
    private String xnama,xemail,xpass,xttl,xalamat,xtelepon,xgender,xagama,xroles;
    private TextInputEditText nama,email,pass,ttl,alamat,telepon,gender,agama,roles;
    private TextView btnUpdate;
    private String ynama, yemail, ypass, yttl, yalamat, ytelepon, ygender, yagama, yroles;
    final Calendar myCalendar = Calendar.getInstance();
    private String selectedGender = "L", selectedRoles = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent terima = getIntent();
        xid = terima.getIntExtra("xId", -1);
        xnama = terima.getStringExtra("xNama");
        xemail = terima.getStringExtra("xEmail");
        xpass = terima.getStringExtra("xPass");
        xttl = terima.getStringExtra("xTgl_lahir");
        xalamat = terima.getStringExtra("xAlamat");
        xtelepon = terima.getStringExtra("xHp");
        xgender = terima.getStringExtra("xGender");
        xagama = terima.getStringExtra("xAgama");
        xroles = terima.getStringExtra("xRoles");


        nama = findViewById(R.id.et_nama);
        email = findViewById(R.id.et_email);
        pass = findViewById(R.id.et_password);
        ttl = findViewById(R.id.et_tglLahir);
        alamat = findViewById(R.id.et_alamat);
        telepon = findViewById(R.id.et_noHp);
        gender = findViewById(R.id.et_gender);
        agama = findViewById(R.id.et_agama);
        roles = findViewById(R.id.et_roles);
        btnUpdate = findViewById(R.id.btn_update);

        nama.setText(xnama);
        email.setText(xemail);
        pass.setText(xpass);
        ttl.setText(xttl);
        alamat.setText(xalamat);
        telepon.setText(xtelepon);
        gender.setText(xgender);
        agama.setText(xagama);
        roles.setText(xroles);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {
                String myFormat = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                ttl.setText(sdf.format(myCalendar.getTime()));
            }
        };
        ttl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(UpdateActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsGender();
            }
            private void showOptionsGender() {
                String[] genders = {"L", "P"};
                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateActivity.this);
                builder.setTitle("Pilih Gender");
                builder.setSingleChoiceItems(genders, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedGender = genders[which];
                    }
                });
                builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gender.setText(selectedGender);
                    }
                });
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

        roles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsRoles();
            }
            private void showOptionsRoles() {
                String[] roless = {"admin", "pegawai"};
                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateActivity.this);
                builder.setTitle("Pilih Roles");
                builder.setSingleChoiceItems(roless, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedRoles = roless[which];
                    }
                });
                builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        roles.setText(selectedRoles);
                    }
                });
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ynama = nama.getText().toString();
                yemail = email.getText().toString();
                ypass  = pass.getText().toString();
                yttl = ttl.getText().toString();
                yalamat = alamat.getText().toString();
                ytelepon = telepon.getText().toString();
                ygender = gender.getText().toString();
                yagama = agama.getText().toString();
                yroles = roles.getText().toString();
                updateData();
            }
        });
    }
    private void updateData(){
        APIService arData = APIConfig.loadData().create(APIService.class);
        Call<ResponseModel> ubahData = arData.UpdateData(xid, ynama, yemail,ypass,yttl,yalamat,ytelepon,ygender,yagama,yroles);

        ubahData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(UpdateActivity.this, "kode : "+kode+" | pesan : "+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Gagal Menghubungi Server | "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}