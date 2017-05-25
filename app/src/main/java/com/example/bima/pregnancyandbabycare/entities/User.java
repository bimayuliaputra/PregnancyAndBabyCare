package com.example.bima.pregnancyandbabycare.entities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RAHMA on 5/18/2017.
 */

public class User {
    private Integer id;
    private String Username, Password;

    public User(JSONObject jsonObject) throws JSONException {
        id = jsonObject.getInt("Id_Pasien");
        Username = jsonObject.getString("Username_Pasien");
        Password = jsonObject.getString("Password_Pasien");
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
}
