package com.example.satumenitaja;

import android.app.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



import java.util.List;

public class AdapterPengingat extends RecyclerView.Adapter<AdapterPengingat.MyViewHolder> {
    final List<ModelPengingat> listModel;
    final Activity activity;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public AdapterPengingat(List<ModelPengingat> listModel,Activity activity){
        this.listModel = listModel;
        this.activity = activity;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View ViewItem = inflater.inflate(R.layout.layout_item,parent,false);
        return new MyViewHolder(ViewItem);
    }

     @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        final ModelPengingat data = listModel.get(position);
        holder.tv_surah.setText(" Surah : "+ data.getNamaSurah());
        holder.tv_status.setText(" status : "+ data.getStatusPengingat());
        holder.img_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(activity, holder.img_more);
                //inflating menu from xml resource
                popup.inflate(R.menu.crud_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.edit_reminder:
                                FragmentManager fragmentManager = ((AppCompatActivity)activity).getSupportFragmentManager();
                                DialogFrom dialog = new DialogFrom(
                                        data.getNamaSurah(),
                                        data.getStatusPengingat(),
                                        data.getKey(),
                                        "ubah"
                                );
                                dialog.show(fragmentManager,"from");
                                return true;

                            case R.id.delete_Reminder:
                                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                                builder.setPositiveButton("iya", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int iya) {
                                        databaseReference.child("Pengingat").child(data.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Toast.makeText(activity," Data Berhasil di hapus", Toast.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(activity, " Gagal Menghapus ", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                }).setNegativeButton("tidak", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int tidak) {
                                        dialog.dismiss();
                                    }
                                }).setMessage(" Apakah Yakin mau menghapus ? " + data.getNamaSurah());
                                builder.show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                //displaying the popup
                popup.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_surah, tv_status;
        ImageView img_more;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_surah = itemView.findViewById(R.id.card_nama);
            tv_status = itemView.findViewById(R.id.card_status);
            img_more = itemView.findViewById(R.id.img_more);
        }
    }
}
