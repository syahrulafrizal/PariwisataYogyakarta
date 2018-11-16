package com.syahrul.pariwisatayogyakarta.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondRetroServer {
    private static final String baseUrl = "http://shielded-semiconduc.000webhostapp.com/upload-mobile/Jogja-Pariwisata/";

    private static Retrofit retrofit;

    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
