package com.example.bima.pregnancyandbabycare.entities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RAHMA on 5/16/2017.
 */

public class KontrolIbu {
    private Integer id, Tekanan_Darah, Berat_Badan, Umur_Kehamilan, Tinggi_Fundus, Denyut_Jantung_Janin, Hamil_Ke;
    private String Keluhan, Letak_Janin, Tindakan, Nasehat, Tgl_Kontrol, Tgl_Kembali, Tgl_Htp, Nama_Pasien;

    public KontrolIbu(JSONObject jsonObject) throws JSONException {
        id = jsonObject.getInt("Id_Kontrol_Ibu");
        Keluhan = jsonObject.getString("Keluhan");
        Letak_Janin =jsonObject.getString("Letak_Janin");
        Tindakan = jsonObject.getString("Tindakan");
        Nasehat = jsonObject.getString("Nasehat");
        Tgl_Kontrol = jsonObject.getString("Tgl_Kontrol");
        Tgl_Kembali = jsonObject.getString("Tgl_Kembali");
        Tgl_Htp = jsonObject.getString("Tgl_Htp");
        Nama_Pasien = jsonObject.getString("Nama_Pasien");
        Tekanan_Darah = jsonObject.getInt("Tekanan_Darah");
        Berat_Badan = jsonObject.getInt("Berat_Badan");
        Umur_Kehamilan = jsonObject.getInt("Umur_Kehamilan");
        Tinggi_Fundus = jsonObject.getInt("Tinggi_Fundus");
        Denyut_Jantung_Janin = jsonObject.getInt("Denyut_Jantung_Janin");
        Hamil_Ke = jsonObject.getInt("Hamil_Ke");
    }

    public Integer getId() {
        return id;
    }

    public String getKeluhan() {
        return Keluhan;
    }

    public String getLetak_Janin() {
        return Letak_Janin;
    }

    public String getTindakan() {
        return Tindakan;
    }

    public String getNasehat() {
        return Nasehat;
    }

    public String getTgl_Kontrol() {
        return Tgl_Kontrol;
    }

    public String getTgl_Kembali() {
        return Tgl_Kembali;
    }

    public String getTgl_Htp() {
        return Tgl_Htp;
    }

    public String getNama_Pasien() {
        return Nama_Pasien;
    }

    public Integer getTekanan_Darah() {
        return Tekanan_Darah;
    }

    public Integer getBerat_Badan() {
        return Berat_Badan;
    }

    public Integer getUmur_Kehamilan() {
        return Umur_Kehamilan;
    }

    public Integer getTinggi_Fundus() {
        return Tinggi_Fundus;
    }

    public Integer getDenyut_Jantung_Janin() {
        return Denyut_Jantung_Janin;
    }

    public Integer getHamil_Ke() {
        return Hamil_Ke;
    }
}
