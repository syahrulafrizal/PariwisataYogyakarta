package com.syahrul.pariwisatayogyakarta.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.syahrul.pariwisatayogyakarta.R;
import com.syahrul.pariwisatayogyakarta.activity.DetailTempat;
import com.syahrul.pariwisatayogyakarta.model.ModelDataPariwisata;

public class HolderData extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView namaTempat;
    ModelDataPariwisata pariwisata;
    Context context;

    public HolderData(@NonNull View itemView) {
        super(itemView);

        namaTempat = itemView.findViewById(R.id.textNama);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, DetailTempat.class);
        intent.putExtra("name", pariwisata.getNamaPariwisata());
        intent.putExtra("gambar", pariwisata.getGambarPariwisata());
        intent.putExtra("alamat", pariwisata.getAlamatPariwisata());
        intent.putExtra("detail", pariwisata.getDetailPariwisata());
        context.startActivity(intent);
    }
}
