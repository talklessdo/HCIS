package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class NotifikasiActivity2 extends AppCompatActivity implements View.OnClickListener {

    private  int notificationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi2);

        findViewById(R.id.setBtn2).setOnClickListener(this);
        findViewById(R.id.cancelBtn2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TimePicker timePicker2 = findViewById(R.id.timePicker2);

        Intent intent = new Intent(NotifikasiActivity2.this, AlarmReceiver2.class);
        intent.putExtra("notificationId", notificationId);


        PendingIntent alarmIntent2 = PendingIntent.getBroadcast(
                NotifikasiActivity2.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
        );

        AlarmManager alarmManager2 = (AlarmManager) getSystemService(ALARM_SERVICE);

        switch (v.getId()){
            case R.id.setBtn2:
                int hour2 = timePicker2.getCurrentHour();
                int minute2 = timePicker2.getCurrentMinute();

                Calendar startTime2 = Calendar.getInstance();
                startTime2.set(Calendar.HOUR_OF_DAY, hour2);
                startTime2.set(Calendar.MINUTE, minute2);
                startTime2.set(Calendar.SECOND, 0);
                long alarmStartTime2 = startTime2.getTimeInMillis();

                alarmManager2.set(AlarmManager.RTC_WAKEUP, alarmStartTime2, alarmIntent2);

                Toast.makeText(this, "Notifikasi Presensi Pulang Di Aktifkan", Toast.LENGTH_SHORT).show();

                break;
            case R.id.cancelBtn2:
                alarmManager2.cancel(alarmIntent2);
                Toast.makeText(this, "Notifikasi Presensi Pulang DI Nonaktifkan", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}