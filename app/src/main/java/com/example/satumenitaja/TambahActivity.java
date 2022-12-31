package com.example.satumenitaja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahActivity extends AppCompatActivity {

    EditText edtSurah, edtStatus;
    Button btnPengingat;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        edtSurah = findViewById(R.id.edt_surah);
        edtStatus = findViewById(R.id.edt_status);
        btnPengingat = findViewById(R.id.btn_tambah_pengingat);

        btnPengingat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getSurah = edtSurah.getText().toString();
                String getstatus = edtStatus.getText().toString();

                if (getSurah.isEmpty()){
                    edtSurah.setError("Masukan Surah");
                }else if (getstatus.isEmpty()){
                    edtStatus.setError("Ubah Status");
                }
                else{
                    databaseReference.child("Pengingat").push().setValue(new ModelPengingat(getSurah,getstatus)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(TambahActivity.this," Pengigat Berhasil Di tambahkan", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TambahActivity.this," Gagal Menambahkan Pengingat ", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }

}