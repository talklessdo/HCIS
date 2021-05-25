package com.example.tugasakhir.Page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tugasakhir.Fragment.fragmentHome;
import com.example.tugasakhir.R;
import com.example.tugasakhir.Response.fragmentFitur;
import com.example.tugasakhir.Response.fragmentSetting;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loadFragment(new fragmentHome()); //yang pertama kali ditampilkan

        BottomNavigationView navigation = findViewById(R.id.nav_bar);
        navigation.setOnNavigationItemSelectedListener(this);

    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      Fragment frag = null;

      switch (item.getItemId()) {
          case R.id.nav_home:
              frag = new fragmentHome();
              getSupportFragmentManager().popBackStackImmediate();
              loadFragment(frag);
              break;
          case R.id.nav_fitur:
              frag = new fragmentFitur();
              getSupportFragmentManager().popBackStackImmediate();
              loadFragment(frag);
              break;
          case R.id.nav_setting:
              frag = new fragmentSetting();
              getSupportFragmentManager().popBackStackImmediate();
              loadFragment(frag);
              break;
      }

        return true;
    }
}