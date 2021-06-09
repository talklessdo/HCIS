package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugasakhir.Helper.APIConfig;
import com.example.tugasakhir.Helper.APIService;
import com.example.tugasakhir.Helper.UserManager;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import Model.ResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class tambahPegawai extends AppCompatActivity {

    private TextInputEditText etnama,etemail,etpassword,ettgl_lahir,etalamat,etnoHp,etgender,etagama,etroles;
    private TextView btnTambah;
    private String nama,email,password,tgl_lahir,alamat,telepon,gender,agama,roles ;
    final Calendar myCalendar = Calendar.getInstance();
    private String selectedGender = "L", selectedRoles = "admin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pegawai);

        etnama = findViewById(R.id.tmb_nama);
        etemail = findViewById(R.id.tmb_email);
        etpassword = findViewById(R.id.tmb_password);
        ettgl_lahir = findViewById(R.id.tmb_tglLahir);
        etalamat = findViewById(R.id.tmb_alamat);
        etnoHp = findViewById(R.id.tmb_noHp);
        etgender = findViewById(R.id.tmb_gender);
        etagama = findViewById(R.id.tmb_agama);
        etroles = findViewById(R.id.tmb_roles);
        btnTambah = findViewById(R.id.btn_tambah);


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
                ettgl_lahir.setText(sdf.format(myCalendar.getTime()));
            }
        };
        ettgl_lahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(tambahPegawai.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        etgender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsGender();
            }
            private void showOptionsGender() {
                String[] genders = {"L", "P"};
                AlertDialog.Builder builder = new AlertDialog.Builder(tambahPegawai.this);
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
                        etgender.setText(selectedGender);
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

        etroles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsRoles();
            }
            private void showOptionsRoles() {
                String[] roles = {"admin", "pegawai"};
                AlertDialog.Builder builder = new AlertDialog.Builder(tambahPegawai.this);
                builder.setTitle("Pilih Roles");
                builder.setSingleChoiceItems(roles, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedRoles = roles[which];
                    }
                });
                builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        etroles.setText(selectedRoles);
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

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = etnama.getText().toString();
                email = etemail.getText().toString();
                password = etpassword.getText().toString();
                tgl_lahir = ettgl_lahir.getText().toString();
                alamat = etalamat.getText().toString();
                telepon = etnoHp.getText().toString();
                gender = etgender.getText().toString();
                agama = etagama.getText().toString();
                roles = etroles.getText().toString();

                if (nama.isEmpty()){
                    etnama.requestFocus();
                    etnama.setError("Nama tidak boleh kosong");
                    return;
                }else if (email.isEmpty()){
                    etemail.requestFocus();
                    etemail.setError("Email tidak boleh kosong");
                    return;
                }else if (password.isEmpty()){
                    etpassword.requestFocus();
                    etpassword.setError("Password tidak boleh kosong");
                    return;
                }else if (alamat.isEmpty()){
                    etalamat.requestFocus();
                    etalamat.setError("Alamat tidak boleh kosong");
                    return;
                }else if (tgl_lahir.isEmpty()){
                    ettgl_lahir.requestFocus();
                    ettgl_lahir.setError("Alamat tidak boleh kosong");
                    return;
                }
                else if (telepon.isEmpty()){
                    etnoHp.requestFocus();
                    etnoHp.setError("Telepon tidak boleh kosong");
                    return;
                }else if (agama.isEmpty()){
                    etagama.requestFocus();
                    etagama.setError("Agama tidak boleh kosong");
                    return;
                }else {
                    createData();
                }
            }
        });
    }
    private void createData(){
        APIService arData = APIConfig.loadData().create(APIService.class);
        Call<ResponseModel> simpanData = arData.CreateData(nama,email,password,tgl_lahir,alamat,telepon,gender,agama,roles);

        simpanData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(tambahPegawai.this, "kode : "+kode+" | pesan : "+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(tambahPegawai.this, "Gagal Menghubungi Server | "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}