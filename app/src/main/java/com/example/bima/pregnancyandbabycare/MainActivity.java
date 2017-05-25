package com.example.bima.pregnancyandbabycare;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bima.pregnancyandbabycare.entities.User;
import com.example.bima.pregnancyandbabycare.lib.Fungsi;
import com.example.bima.pregnancyandbabycare.lib.InternetHelper;
import com.example.bima.pregnancyandbabycare.lib.InternetTask;
import com.example.bima.pregnancyandbabycare.lib.KeyValue;
import com.example.bima.pregnancyandbabycare.lib.OnInternetTaskFinishedListener;
import com.example.bima.pregnancyandbabycare.lib.UtilityHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnInternetTaskFinishedListener {
    public Button btnLogin;
    private EditText txtUsername, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        if(sharedPreferences.getBoolean("logined", false)){
            this.openHome(sharedPreferences.getString("Username_Pasien",""));
        }
        this.initComponent();
    }

    private void initComponent() {
        this.txtUsername = (EditText) this.findViewById(R.id.txtUsername);
        this.txtPassword = (EditText) this.findViewById(R.id.txtPassword);
        this.btnLogin = (Button) this.findViewById(R.id.btnLogin);
    }

    public void btnOnklik(View view){
        Button b = (Button) view;
        if (b == this.btnLogin)
        {
            this.callLogin();
        }
    }

    private void callLogin(){
        String username = this.txtUsername.getText().toString();
        String password = this.txtPassword.getText().toString();
        ArrayList<KeyValue> data = new ArrayList<>();
        data.add(new KeyValue("m", Fungsi.LOGIN));
        data.add(new KeyValue("Username_Pasien", username));
        data.add(new KeyValue("Password_Pasien", password));
        this.connectApi(InternetHelper.URI, Fungsi.LOGIN, data);
    }

    private void connectApi(String apiUrl, String tag, ArrayList<KeyValue> requestData) {
        String urlString = apiUrl;
        InternetTask InternetTask = new InternetTask("POST", urlString,
                requestData);
        InternetTask.setOnInternetTaskFinishedListener(this);
        InternetTask.setTag(tag);
        InternetTask.execute();
    }

    private void saveCredentials(User user){
        SharedPreferences handler = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = handler.edit();
        editor.putString("Username_Pasien", user.getPassword());
        editor.putString("Password_Pasien", user.getUsername());
        editor.putInt("Id_Pasien", user.getId());
        editor.putBoolean("logined", true);
        editor.apply();
        editor.commit();
    }

    private void openHome(String username){
        Intent i = new Intent(this.getApplicationContext(), Main2Activity.class);
        i.putExtra("Username_Pasien", username);
        this.startActivity(i);
        this.finish();
    }

    private void processLoginApiResponse(String responseStr) {
        try
        {
            JSONObject reader = new JSONObject(responseStr);
            int code = reader.getInt("code");
            if(code == 200)
            {
                JSONObject userJson = reader.getJSONArray("data").getJSONObject(0);
                User user = new User(userJson);
                this.saveCredentials(user);
                this.openHome(user.getUsername());
            }
            else
            {
                String message = reader.getString("message");
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }
        catch (JSONException e)
        {
            UtilityHelper.showAlert(this, "JSON Parsing Error", e.getMessage());
        }
    }

    @Override
    public void OnInternetTaskFinished(InternetTask InternetTask) {
        String tag = InternetTask.getTag();
        if(tag.equals(Fungsi.LOGIN))
        {
            this.processLoginApiResponse(InternetTask.getResponseString());
        }
    }

    @Override
    public void OnInternetTaskFailed(InternetTask InternetTask) {
        UtilityHelper.showAlert(this, "Internet Task Failed",
                InternetTask.getException().getMessage());
    }
}
