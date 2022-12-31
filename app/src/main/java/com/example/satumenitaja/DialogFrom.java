package com.example.satumenitaja;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogFrom extends DialogFragment {
    String namaSurah,statusPengingat,key, pilih;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public DialogFrom(String namaSurah, String statusPengingat, String key, String pilih) {
        this.namaSurah = namaSurah;
        this.statusPengingat = statusPengingat;
        this.key = key;
        this.pilih = pilih;
    }
    EditText Edt_surah, Edt_status;
    Button btn_Edit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.activity_tambah,container,false);
        Edt_surah = view.findViewById(R.id.edt_surah);
       Edt_status = view.findViewById(R.id.edt_status);
        btn_Edit = view.findViewById(R.id.btn_tambah_pengingat);

        Edt_surah.setText(namaSurah);
        Edt_status.setText(statusPengingat);

        btn_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String surah = Edt_surah.getText().toString();
                String status = Edt_status.getText().toString();

                if (pilih.equals("ubah")){
                    databaseReference.child("Pengingat").child(key).setValue(new ModelPengingat(surah,status)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(view.getContext()," Berhasil Di update",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(view.getContext()," gagal Di update",Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if(dialog!= null){
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
