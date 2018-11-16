package com.syahrul.pariwisatayogyakarta.presenter;

import com.syahrul.pariwisatayogyakarta.api.ApiRequest;
import com.syahrul.pariwisatayogyakarta.api.DataResponse;
import com.syahrul.pariwisatayogyakarta.api.RetroServer;
import com.syahrul.pariwisatayogyakarta.view.ViewDataPariwisata;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterDataPariwisataImp implements PresenterDataPariwisata {

    ViewDataPariwisata viewDataPariwisata;

    public PresenterDataPariwisataImp(ViewDataPariwisata viewDataPariwisata) {
        this.viewDataPariwisata = viewDataPariwisata;
    }

    @Override
    public void sendResponse() {
        ApiRequest apiRequest = RetroServer.getClient().create(ApiRequest.class);
        Call<DataResponse> dataResponseCall = apiRequest.listData();
        dataResponseCall.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
               if (response.isSuccessful()){
                   try {
                       viewDataPariwisata.onSuccess(response.body().getData());
                   }catch (Exception e){
                       viewDataPariwisata.onFailed(e.getMessage());
                   }
               }else {
                   viewDataPariwisata.onFailed("Silahkan Cek Koneksi Anda");
               }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                viewDataPariwisata.onFailed(t.toString());
            }
        });
    }
}
