package com.example.satumenitaja;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterAlquran extends RecyclerView.Adapter<AdapterAlquran.AlquranViewHolder> {

    ArrayList<Surah> arayistsurah;

    public AdapterAlquran(ArrayList<Surah> arayistsurah) {
        this.arayistsurah = arayistsurah;

    }
    public void filterlist(ArrayList<Surah> filterlist) {
        this.arayistsurah = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AlquranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_surah, parent, false);
        return new AlquranViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlquranViewHolder holder, int position) {
        final Surah surah = arayistsurah.get(position);

        holder.surah.setText(surah.getSurah());
        holder.ayat.setText(surah.getAyat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailSurah.class);
                intent.putExtra("ALQURAN",surah);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arayistsurah.size();
    }

    public class AlquranViewHolder extends RecyclerView.ViewHolder {
        TextView surah,ayat;
        public AlquranViewHolder(@NonNull View itemView) {
            super(itemView);
            surah = itemView.findViewById(R.id.txt_surah);
            ayat = itemView.findViewById(R.id.txt_ayat);
        }
    }
}
