package com.syahrul.pariwisatayogyakarta.view;

import com.syahrul.pariwisatayogyakarta.model.ModelDataPariwisata;

import java.util.List;

public interface ViewDataPariwisata {

    void onSuccess(List<ModelDataPariwisata> dataPariwisataList);

    void onFailed (String text);
}
