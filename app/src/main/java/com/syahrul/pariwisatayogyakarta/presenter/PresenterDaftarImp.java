package com.syahrul.pariwisatayogyakarta.presenter;

import android.text.TextUtils;

import com.syahrul.pariwisatayogyakarta.api.ApiRequest;
import com.syahrul.pariwisatayogyakarta.api.DaftarResponse;
import com.syahrul.pariwisatayogyakarta.api.LoginResponse;
import com.syahrul.pariwisatayogyakarta.api.SecondRetroServer;
import com.syahrul.pariwisatayogyakarta.view.ViewDaftar;
import com.syahrul.pariwisatayogyakarta.view.ViewLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterDaftarImp implements PresenterDaftar {

    ViewDaftar viewDaftar;

    public PresenterDaftarImp(ViewDaftar viewDaftar) {
        this.viewDaftar = viewDaftar;
    }

    @Override
    public void registrasi(final String email, final String password) {

        if (TextUtils.isEmpty(email)){
            viewDaftar.showValidationError("inEmail");
        }else if (TextUtils.isEmpty(password)){
            viewDaftar.showValidationError("inPass");
        } else {
            ApiRequest apiRequest = SecondRetroServer.getClient().create(ApiRequest.class);
            Call<DaftarResponse> daftarResponseCall = apiRequest.statusDaftar(email, password);
            daftarResponseCall.enqueue(new Callback<DaftarResponse>() {
                @Override
                public void onResponse(Call<DaftarResponse> call, Response<DaftarResponse> response) {
                    if (response.isSuccessful()){
                        try {
                            if (TextUtils.isEmpty(email)){
                                viewDaftar.showValidationError("inEmail");
                            }else if (TextUtils.isEmpty(password)){
                                viewDaftar.showValidationError("inPass");
                            }else {
                                if (response.body().getStatus()){
                                    viewDaftar.showDaftarnSuccess("Registrasi Berhasil");
                                }else {
                                    viewDaftar.showDaftarFailed("Registrasi Gagal");
                                }
                            }
                        }catch (Exception e){
                            viewDaftar.showDaftarFailed(e.getMessage());
                        }
                    }else {
                        viewDaftar.showDaftarFailed("Silahkan Cek Koneksi Anda");
                    }
                }

                @Override
                public void onFailure(Call<DaftarResponse> call, Throwable t) {
                    viewDaftar.showDaftarFailed(t.toString());
                }
            });
        }
    }
}
