package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class NotifikasiActivity extends AppCompatActivity implements View.OnClickListener{

    private  int notificationId = 1;
    Button notifPulang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        findViewById(R.id.setBtn).setOnClickListener(this);
        findViewById(R.id.cancelBtn).setOnClickListener(this);
        notifPulang = findViewById(R.id.pulangBtn);
        notifPulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotifikasiActivity.this, NotifikasiActivity2.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        TimePicker timePicker = findViewById(R.id.timePicker);


        Intent intent = new Intent(NotifikasiActivity.this, AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);


        PendingIntent alarmIntent = PendingIntent.getBroadcast(
                NotifikasiActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
        );

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        switch (v.getId()){
            case R.id.setBtn:
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hour);
                startTime.set(Calendar.MINUTE, minute);
                startTime.set(Calendar.SECOND, 0);
//                long alarmStartTime = startTime.getTimeInMillis();
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, startTime.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);
//                alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
//                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime,AlarmManager.INTERVAL_DAY,alarmIntent);



                Toast.makeText(this, "Notifikasi Presensi Masuk Di Aktifkan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancelBtn:
                alarmManager.cancel(alarmIntent);
                Toast.makeText(this, "Notifikasi Presensi Masuk DI Nonaktifkan", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}