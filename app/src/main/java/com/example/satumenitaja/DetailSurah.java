package com.example.satumenitaja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailSurah extends AppCompatActivity {

    TextView txtsurah,txtayat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surah);

        txtsurah = findViewById(R.id.txt_surah);
        txtayat = findViewById(R.id.txt_ayat);

        Surah surah = getIntent().getParcelableExtra("ALQURAN");
        txtsurah.setText(surah.getSurah());
        txtayat.setText(surah.getAyat());
    }
}