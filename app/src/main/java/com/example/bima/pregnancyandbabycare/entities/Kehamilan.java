package com.example.bima.pregnancyandbabycare.entities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RAHMA on 5/17/2017.
 */

public class Kehamilan {
    private Integer Id_Kehamilan, Hamil_Ke;

    public Kehamilan(JSONObject jsonObject) throws JSONException {
        Id_Kehamilan = jsonObject.getInt("Id_Kehamilan");
        Hamil_Ke = jsonObject.getInt("Hamil_Ke");
    }

    public Integer getId_Kehamilan() {
        return Id_Kehamilan;
    }

    public Integer getHamil_Ke() {
        return Hamil_Ke;
    }
}
