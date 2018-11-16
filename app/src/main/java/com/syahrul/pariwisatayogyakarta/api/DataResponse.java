package com.syahrul.pariwisatayogyakarta.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.syahrul.pariwisatayogyakarta.model.ModelDataPariwisata;

import java.util.List;

public class DataResponse {
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("data")
    @Expose
    private List<ModelDataPariwisata> data = null;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public List<ModelDataPariwisata> getData() {
        return data;
    }

    public void setData(List<ModelDataPariwisata> data) {
        this.data = data;
    }

}
