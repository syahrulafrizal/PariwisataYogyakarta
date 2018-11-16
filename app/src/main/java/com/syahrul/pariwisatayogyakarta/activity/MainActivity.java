package com.syahrul.pariwisatayogyakarta.activity;

import android.app.ProgressDialog;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.syahrul.pariwisatayogyakarta.R;
import com.syahrul.pariwisatayogyakarta.adapter.AdapterDataPariwisata;
import com.syahrul.pariwisatayogyakarta.model.ModelDataPariwisata;
import com.syahrul.pariwisatayogyakarta.presenter.PresenterDataPariwisata;
import com.syahrul.pariwisatayogyakarta.presenter.PresenterDataPariwisataImp;
import com.syahrul.pariwisatayogyakarta.view.ViewDataPariwisata;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewDataPariwisata, View.OnClickListener {

    PresenterDataPariwisata presenterDataPariwisata;
    ProgressDialog pd;

    RecyclerView list;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;

    ImageView imgError;
    Button btnError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pd = new ProgressDialog(this);
        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);
        pd.show();

        list = findViewById(R.id.listData);
        mManager = new LinearLayoutManager(this);
        list.setLayoutManager(mManager);

        imgError = findViewById(R.id.imageViewNotFouund);
        btnError = findViewById(R.id.coba);

        presenterDataPariwisata = new PresenterDataPariwisataImp(this);
        presenterDataPariwisata.sendResponse();

    }

    @Override
    public void onSuccess(List<ModelDataPariwisata> dataPariwisataList) {
        mAdapter = new AdapterDataPariwisata(this, dataPariwisataList);
        list.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        list.setItemAnimator(new DefaultItemAnimator());

        list.setVisibility(View.VISIBLE);
        imgError.setVisibility(View.GONE);
        btnError.setVisibility(View.GONE);

        pd.dismiss();
    }

    @Override
    public void onFailed(String text) {
        list.setVisibility(View.GONE);
        imgError.setVisibility(View.VISIBLE);
        btnError.setVisibility(View.VISIBLE);
        pd.dismiss();
    }

    @Override
    public void onClick(View view) {

    }
}
