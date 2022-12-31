package com.example.satumenitaja;

import androidx.fragment.app.Fragment;

public class ModelPengingat {
    private String namaSurah;
    private String statusPengingat;
    private String key;

    public ModelPengingat(){}
    public ModelPengingat(String namaSurah, String statusPengingat) {
        this.namaSurah = namaSurah;
        this.statusPengingat = statusPengingat;
    }

    public String getNamaSurah() {
        return namaSurah;
    }

    public void setNamaSurah(String namaSurah) {
        this.namaSurah = namaSurah;
    }

    public String getStatusPengingat() {
        return statusPengingat;
    }

    public void setStatusPengingat(String statusPengingat) {
        this.statusPengingat = statusPengingat;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}