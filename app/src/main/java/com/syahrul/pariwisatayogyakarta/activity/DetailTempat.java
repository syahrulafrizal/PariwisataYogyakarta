package com.syahrul.pariwisatayogyakarta.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.syahrul.pariwisatayogyakarta.R;

public class DetailTempat extends AppCompatActivity {

    Intent getData;

    String nama, alamat, gambar, detail;

    ImageView imgTempat;
    TextView txtNama, txtAlamat, txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tempat);

        getData = getIntent();

        nama = getData.getStringExtra("name");
        alamat = getData.getStringExtra("alamat");
        gambar = getData.getStringExtra("gambar");
        detail = getData.getStringExtra("detail");

        imgTempat = findViewById(R.id.imageViewTempat);
        txtNama = findViewById(R.id.textName);
        txtAlamat = findViewById(R.id.textAlamat);
        txtDetail = findViewById(R.id.textDetail);

        Picasso.with(this)
                .load(gambar)
                .into(imgTempat);

        txtNama.setText(nama);
        txtAlamat.setText(alamat);
        txtDetail.setText(detail);
    }
}
