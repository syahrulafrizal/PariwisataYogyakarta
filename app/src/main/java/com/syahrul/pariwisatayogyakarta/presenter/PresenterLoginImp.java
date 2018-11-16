package com.syahrul.pariwisatayogyakarta.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.syahrul.pariwisatayogyakarta.api.ApiRequest;
import com.syahrul.pariwisatayogyakarta.api.LoginResponse;
import com.syahrul.pariwisatayogyakarta.api.SecondRetroServer;
import com.syahrul.pariwisatayogyakarta.view.ViewLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterLoginImp implements PresenterLogin {

    private ViewLogin viewLogin;


    public PresenterLoginImp(ViewLogin viewLogin){
        this.viewLogin = viewLogin;
    }



    @Override
    public void cekLogin(final String email, final String password) {

        if (TextUtils.isEmpty(email)){
            viewLogin.showValidationError("inEmail");
        }else if (TextUtils.isEmpty(password)){
            viewLogin.showValidationError("inPass");
        } else {
            ApiRequest apiRequest = SecondRetroServer.getClient().create(ApiRequest.class);
            Call<LoginResponse> loginResponseCall = apiRequest.statusLogin(email, password);
            loginResponseCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful()){
                        try {
                            if (TextUtils.isEmpty(email)){
                                viewLogin.showValidationError("inEmail");
                            }else if (TextUtils.isEmpty(password)){
                                viewLogin.showValidationError("inPass");
                            }else {
                                if (response.body().getStatus()){
                                    viewLogin.showLoginSuccess("Login Berhasil");
                                }else {
                                    viewLogin.showLoginFailed("Login Gagal");
                                }
                            }
                        }catch (Exception e){
                            viewLogin.showLoginFailed(e.getMessage());
                        }
                    }else {
                        viewLogin.showLoginFailed("Silahkan Cek Koneksi Anda");
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    viewLogin.showLoginFailed(t.toString());
                }
            });
        }
    }
}
