package com.syahrul.pariwisatayogyakarta.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequest {

    @GET("jsonBootcamp.php")
    Call<DataResponse> listData();

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> statusLogin(@Field("user") String user,
                                    @Field("pass") String pass);

    @FormUrlEncoded
    @POST("daftar.php")
    Call<DaftarResponse> statusDaftar(@Field("user") String user,
                                    @Field("pass") String pass);
}
