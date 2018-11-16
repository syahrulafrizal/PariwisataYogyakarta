package com.syahrul.pariwisatayogyakarta.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.syahrul.pariwisatayogyakarta.R;
import com.syahrul.pariwisatayogyakarta.model.ModelDataPariwisata;

import java.util.List;

public class AdapterDataPariwisata extends RecyclerView.Adapter<HolderData> {

    private Context context;
    private List<ModelDataPariwisata> modelDataPariwisataList;

    public AdapterDataPariwisata(Context context, List<ModelDataPariwisata> modelDataPariwisataList) {
        this.context = context;
        this.modelDataPariwisataList = modelDataPariwisataList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_list_data, viewGroup, false);
        return new HolderData(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holderData, int i) {
        ModelDataPariwisata dataPariwisata = modelDataPariwisataList.get(i);

        holderData.namaTempat.setText(dataPariwisata.getNamaPariwisata());
        holderData.context = context;
        holderData.pariwisata = dataPariwisata;
    }

    @Override
    public int getItemCount() {
        return modelDataPariwisataList.size();
    }
}
