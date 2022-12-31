package com.example.satumenitaja;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReminderFragment extends Fragment {
FloatingActionButton tambah;
AdapterPengingat adapterPengingat;
DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
ArrayList<ModelPengingat> listpengingat;
RecyclerView tampil_recyclerview;


    public ReminderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reminder, container, false);

        tambah = view.findViewById(R.id.btn_tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),TambahActivity.class));
            }
        });

        tampil_recyclerview = view.findViewById(R.id.tampil_recyclerview);
        //tampil_recyclerview.setHasFixedSize(true);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView.LayoutManager mlayout = new LinearLayoutManager(getActivity());
        tampil_recyclerview.setLayoutManager(mlayout);
        tampil_recyclerview.setItemAnimator(new DefaultItemAnimator());
        tampildata();
        return view;
    }

    private void tampildata() {
        databaseReference.child("Pengingat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listpengingat = new ArrayList<>();
                for (DataSnapshot item : snapshot.getChildren()){
                    ModelPengingat pengingat = item.getValue(ModelPengingat.class);
                    pengingat.setKey(item.getKey());
                    listpengingat.add(pengingat);
                 }
                adapterPengingat = new AdapterPengingat(listpengingat, getActivity());
                tampil_recyclerview.setAdapter(adapterPengingat);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}