package com.example.bima.pregnancyandbabycare.entities;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

/**
 * Created by RAHMA on 5/17/2017.
 */

public class DataArtikel {
    private Integer Id_Artikel;
    private String Judul, Isi, Foto;
    private Uri lokasi;

    public DataArtikel(JSONObject jsonObject) throws JSONException {
        Id_Artikel = jsonObject.getInt("Id_Artikel");
        Judul = jsonObject.getString("Judul");
        Isi = jsonObject.getString("Isi");
        Foto = jsonObject.getString("Foto");
        lokasi = Uri.parse(Foto);
    }

    public Integer getId_Artikel() {
        return Id_Artikel;
    }

    public String getJudul() {
        return Judul;
    }

    public String getIsi() {
        return Isi;
    }

    public String getFoto() {
        return Foto;
    }

    public Uri getLokasi() {
        return lokasi;
    }
}
