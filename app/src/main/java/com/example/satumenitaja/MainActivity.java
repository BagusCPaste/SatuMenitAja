package com.example.satumenitaja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.al_quran);

    }

    Al_QuranFragment al_quranFragment = new Al_QuranFragment();
    ReminderFragment reminderFragment = new ReminderFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.al_quran:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, al_quranFragment).commit();
                return true;

            case R.id.reminder:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, reminderFragment).commit();
                return true;
        }
        return false;
    }
}