package com.example.bima.pregnancyandbabycare.entities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RAHMA on 5/17/2017.
 */

public class Bayi {
    private Integer Id_Bayi, Id_Pasien;
    private String Nama_Bayi;

    public Bayi(JSONObject jsonObject) throws JSONException {
        Id_Bayi = jsonObject.getInt("Id_Persalinan");
        Id_Pasien = jsonObject.getInt("Id_Pasien");
        Nama_Bayi = jsonObject.getString("Nama_Bayi");
    }

    public Integer getId_Bayi() {
        return Id_Bayi;
    }

    public Integer getId_Pasien() {
        return Id_Pasien;
    }

    public String getNama_Bayi() {
        return Nama_Bayi;
    }
}
