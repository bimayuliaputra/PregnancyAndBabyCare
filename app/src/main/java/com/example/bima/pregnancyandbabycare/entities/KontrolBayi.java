package com.example.bima.pregnancyandbabycare.entities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RAHMA on 5/17/2017.
 */

public class KontrolBayi {
    private Integer Id_Kontrol_Bayi, Id_Persalinan, Id_Pasien, Vaksin;
    private String Keluhan, Tgl_Vaksin, Tgl_Kontrol_Bayi, Tgl_Kembali_Bayi, Keterangan, Nama_Bayi, Nama_Pasien;

    public KontrolBayi(JSONObject jsonObject) throws JSONException{
        Id_Kontrol_Bayi = jsonObject.getInt("Id_Kontrol_Bayi");
        Id_Persalinan = jsonObject.getInt("Id_Persalinan");
        Id_Pasien = jsonObject.getInt("Id_Pasien");
        Vaksin = jsonObject.getInt("Vaksin");
        Keluhan = jsonObject.getString("Keluhan");
        Tgl_Vaksin = jsonObject.getString("Tgl_Vaksin");
        Tgl_Kontrol_Bayi = jsonObject.getString("Tgl_Kontrol_Bayi");
        Tgl_Kembali_Bayi = jsonObject.getString("Tgl_Kembali_Bayi");
        Keterangan = jsonObject.getString("Keterangan");
        Nama_Bayi = jsonObject.getString("Nama_Bayi");
        Nama_Pasien = jsonObject.getString("Nama_Pasien");
    }

    public Integer getId_Kontrol_Bayi() {
        return Id_Kontrol_Bayi;
    }

    public Integer getId_Persalinan() {
        return Id_Persalinan;
    }

    public Integer getId_Pasien() {
        return Id_Pasien;
    }

    public Integer getVaksin() {
        return Vaksin;
    }

    public String getKeluhan() {
        return Keluhan;
    }

    public String getTgl_Vaksin() {
        return Tgl_Vaksin;
    }

    public String getTgl_Kontrol_Bayi() {
        return Tgl_Kontrol_Bayi;
    }

    public String getTgl_Kembali_Bayi() {
        return Tgl_Kembali_Bayi;
    }

    public String getKeterangan() {
        return Keterangan;
    }

    public String getNama_Bayi() {
        return Nama_Bayi;
    }

    public String getNama_Pasien() {
        return Nama_Pasien;
    }
}
