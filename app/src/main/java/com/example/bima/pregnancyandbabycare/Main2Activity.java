package com.example.bima.pregnancyandbabycare;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bima.pregnancyandbabycare.entities.*;
import com.example.bima.pregnancyandbabycare.entities.KontrolBayi;
import com.example.bima.pregnancyandbabycare.lib.FormData;
import com.example.bima.pregnancyandbabycare.lib.Fungsi;
import com.example.bima.pregnancyandbabycare.lib.InternetHelper;
import com.example.bima.pregnancyandbabycare.lib.InternetTask;
import com.example.bima.pregnancyandbabycare.lib.OnInternetTaskFinishedListener;
import com.example.bima.pregnancyandbabycare.lib.UtilityHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnInternetTaskFinishedListener {
    private final int CALENDAR = 1;
    private SharedPreferences sharedPreferences;
    private int year, month, day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sharedPreferences = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        ArticleFragment articleFragment = new ArticleFragment();
        FormData formData = new FormData();
        formData.add("m", Fungsi.DATA_ARTIKEL);
        connectApi(formData, Fungsi.DATA_ARTIKEL);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_article) {
            FormData formData = new FormData();
            formData.add("m", Fungsi.DATA_ARTIKEL);
            connectApi(formData, Fungsi.DATA_ARTIKEL);

        } else if (id == R.id.nav_pregnancy) {
            PregnancyFragment pregnancyFragment = new PregnancyFragment();
            //FragmentManager manager = getSupportFragmentManager();
            //manager.beginTransaction(articleFragment.).commit();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, pregnancyFragment, "fragment2");
            fragmentTransaction.commit();
            FormData formData = new FormData();
            formData.add("m", Fungsi.DATA_KEHAMILAN);
            formData.add("Id_Pasien", String.valueOf(sharedPreferences.getInt("Id_Pasien",0)));
            connectApi(formData, Fungsi.DATA_KEHAMILAN);

        } else if (id == R.id.nav_baby) {
            BabyFragment babyFragment = new BabyFragment();
            //FragmentManager manager = getSupportFragmentManager();
            //manager.beginTransaction(articleFragment.).commit();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(R.id.frame, babyFragment, "fragment3");
            fragmentTransaction.commit();
            FormData formData = new FormData();
            formData.add("m", Fungsi.DATA_BAYI);
            formData.add("Id_Pasien", String.valueOf(sharedPreferences.getInt("Id_Pasien",0)));
            connectApi(formData, Fungsi.DATA_BAYI);

        }  else if (id == R.id.nav_keluhan) {
            KeluhanFragment keluhanFragment = new KeluhanFragment();
            //FragmentManager manager = getSupportFragmentManager();
            //manager.beginTransaction(articleFragment.).commit();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, keluhanFragment, "fragment5");
            fragmentTransaction.commit();
        }  else if (id == R.id.nav_HtgKontraksi) {
            HtgKontraksiFragment htgKontraksiFragment = new HtgKontraksiFragment();
            //FragmentManager manager = getSupportFragmentManager();
            //manager.beginTransaction(articleFragment.).commit();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, htgKontraksiFragment, "fragment6");
            fragmentTransaction.commit();
        }  else if (id == R.id.nav_htgKehamilan) {
            HtgKehamilanFragment htgKehamilanFragment = new HtgKehamilanFragment();
            //FragmentManager manager = getSupportFragmentManager();
            //manager.beginTransaction(articleFragment.).commit();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, htgKehamilanFragment, "fragment2");
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void connectApi(FormData formData, String tag){
        InternetTask internetTask = new InternetTask(InternetHelper.URI, formData);
        internetTask.setOnInternetTaskFinishedListener(this);
        internetTask.setTag(tag);
        internetTask.execute();
    }

    @Override
    public void OnInternetTaskFinished(InternetTask internetTask) {
        try {
            JSONObject response = new JSONObject(internetTask.getResponseString());
            if(response.getInt("code")==200){
                switch (internetTask.getTag()){
                    case Fungsi.DATA_KEHAMILAN:
                            data_kehamilan(response);
                        break;
                    case Fungsi.DATA_KONTROL_IBU:
                            data_kontrol_ibu(response);
                        break;
                    case Fungsi.DATA_BAYI:
                        data_bayi(response);
                        break;
                    case Fungsi.DATA_KONTROL_BAYI:
                        data_kontrol_bayi(response);
                        break;
                    case Fungsi.DATA_ARTIKEL:
                        data_artikel(response);
                        break;
                }
            }else{
                UtilityHelper.showAlert(this, "DATA ERROR", response.getString("message")+" - "+response.getString("data"));
            }
        }catch (Exception e){
            UtilityHelper.showAlert(this, "PARSING ERROR !!!",e.getMessage());
        }
    }
    private ArrayList<KontrolIbu> kontrolIbus;
    private ArrayList<String> listKontrolIbus;
    private void data_kontrol_ibu(JSONObject response) {
        try {
            JSONArray jsonArray = response.getJSONArray("data");
            kontrolIbus = new ArrayList<>();
            listKontrolIbus = new ArrayList<>();

            for(int i = 0; i < jsonArray.length(); i++){
                KontrolIbu temp = new KontrolIbu(jsonArray.getJSONObject(i));
                kontrolIbus.add(temp);
                listKontrolIbus.add(temp.getTgl_Kontrol());
            }

            ListView listView = (ListView) findViewById(R.id.list_kontrol);
            if(listKontrolIbus.size()>0){
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listKontrolIbus);
                listView.setAdapter(stringArrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        itemClick(Fungsi.DATA_KONTROL_IBU, i);
                    }
                });
            }
        }catch (Exception e){
            UtilityHelper.showAlert(this, "PARSING ERROR !!!",e.getMessage());
        }
    }

    ArrayList<Kehamilan> kehamilan;
    ArrayList<String> listKehamilan;
    private void data_kehamilan(JSONObject jsonObject) {
        ListView listView = (ListView) findViewById(R.id.list_hamil);
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            kehamilan = new ArrayList<>();
            listKehamilan = new ArrayList<>();

            for(int i = 0; i < jsonArray.length(); i++){
                Kehamilan temp = new Kehamilan(jsonArray.getJSONObject(i));
                kehamilan.add(temp);
                listKehamilan.add("Hamil ke -"+temp.getHamil_Ke().toString());
            }
            if(listKehamilan.size()>0){
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listKehamilan);
                listView.setAdapter(stringArrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        itemClick(Fungsi.DATA_KEHAMILAN, i);
                    }
                });
            }

        } catch (Exception e) {
            UtilityHelper.showAlert(this, "PARSING ERROR !!!",e.getMessage());
        }
    }

    ArrayList<Bayi> bayi;
    ArrayList<String> listBayi;
    private void data_bayi(JSONObject jsonObject){
        ListView listView = (ListView) findViewById(R.id.list_bayi);
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            bayi = new ArrayList<>();
            listBayi = new ArrayList<>();

            for (int i = 0; i<jsonArray.length();i++){
                Bayi temp = new Bayi(jsonArray.getJSONObject(i));
                bayi.add(temp);
                listBayi.add(temp.getNama_Bayi().toString());
            }
            if(listBayi.size()>0){
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listBayi);
                listView.setAdapter(stringArrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        itemClick(Fungsi.DATA_KONTROL_BAYI, i);
                    }
                });
            }
        }catch (Exception e){
            UtilityHelper.showAlert(this, "PARSING ERROR !!!", e.getMessage());
        }
    }

    ArrayList<com.example.bima.pregnancyandbabycare.entities.KontrolBayi> kontrolBayis;
    ArrayList<String> listKontrolBayis;
    private void data_kontrol_bayi(JSONObject response){
        try {
            JSONArray jsonArray = response.getJSONArray("data");
            kontrolBayis = new ArrayList<>();
            listKontrolBayis = new ArrayList<>();

            for(int i = 0; i < jsonArray.length(); i++){
                com.example.bima.pregnancyandbabycare.entities.KontrolBayi temp = new com.example.bima.pregnancyandbabycare.entities.KontrolBayi(jsonArray.getJSONObject(i));
                kontrolBayis.add(temp);
                listKontrolBayis.add(temp.getTgl_Kontrol_Bayi());
            }

            ListView listView = (ListView) findViewById(R.id.list_kontrol_bayi);
            if(listKontrolBayis.size()>0){
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listKontrolBayis);
                listView.setAdapter(stringArrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        itemClick(Fungsi.DETAIL_KONTROL_BAYI, i);
                    }
                });
            }
        }catch (Exception e){
            UtilityHelper.showAlert(this, "PARSING ERROR !!!",e.getMessage());
        }
    }

    private void data_artikel(JSONObject response){
        try {
            ArticleFragment articleFragment = new ArticleFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, articleFragment, "fragment1");
            Bundle bundle = new Bundle();
            bundle.putString("response", String.valueOf(response));
            articleFragment.setArguments(bundle);
            fragmentTransaction.commit();
        }catch (Exception e){
            UtilityHelper.showAlert(this, "PARSING ERROR !!!", e.getMessage());
        }
    }

    private void itemClick(String tag, int i)  {
        FormData formData = new FormData();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (tag) {
            case Fungsi.DATA_KEHAMILAN:
                DetailKontrol pregnancyFragment = new DetailKontrol();
                fragmentTransaction.replace(R.id.frame, pregnancyFragment, "Detail Kontrol");
                formData.add("m", Fungsi.DATA_KONTROL_IBU);
                formData.add("Id_Kehamilan", kehamilan.get(i).getHamil_Ke().toString());
                connectApi(formData, Fungsi.DATA_KONTROL_IBU);
                break;

            case Fungsi.DATA_KONTROL_IBU:
                InformasiKontrolIbu informasiKontrolIbu = new InformasiKontrolIbu();
                Bundle bundle1 = new Bundle();
                KontrolIbu kontrolIbu = this.kontrolIbus.get(i);
                bundle1.putString("tgl_kontrol", kontrolIbu.getTgl_Kontrol().toString());
                bundle1.putString("keluhan", kontrolIbu.getKeluhan());
                bundle1.putString("tekanan_darah", kontrolIbu.getTekanan_Darah().toString());
                bundle1.putString("berat_badan", kontrolIbu.getBerat_Badan().toString());
                bundle1.putString("umur_kehamilan", kontrolIbu.getUmur_Kehamilan().toString());
                bundle1.putString("tinggi_fundus", kontrolIbu.getTinggi_Fundus().toString());
                bundle1.putString("letak_janin", kontrolIbu.getLetak_Janin().toString());
                bundle1.putString("denyut_jantung_janin", kontrolIbu.getDenyut_Jantung_Janin().toString());
                bundle1.putString("tindakan", kontrolIbu.getTindakan().toString());
                bundle1.putString("nasehat", kontrolIbu.getNasehat().toString());
                bundle1.putString("tgl_kelahiran", kontrolIbu.getTgl_Htp().toString());
                bundle1.putString("tgl_kembali", kontrolIbu.getTgl_Kembali().toString());
                informasiKontrolIbu.setArguments(bundle1);
                fragmentTransaction.replace(R.id.frame, informasiKontrolIbu, "ASD");
                break;

            case Fungsi.DATA_KONTROL_BAYI:
                com.example.bima.pregnancyandbabycare.KontrolBayi dataBayi = new com.example.bima.pregnancyandbabycare.KontrolBayi();
                fragmentTransaction.replace(R.id.frame, dataBayi, "Data Bayi");
                formData.add("m", Fungsi.DATA_KONTROL_BAYI);
                formData.add("Id_Persalinan", bayi.get(i).getId_Bayi().toString());
                connectApi(formData, Fungsi.DATA_KONTROL_BAYI);
                break;

            case Fungsi.DETAIL_KONTROL_BAYI:
                DetailKontrolBayi kontrolBayi = new DetailKontrolBayi();
                com.example.bima.pregnancyandbabycare.entities.KontrolBayi  detailKontrolBayi = kontrolBayis.get(i);
                Bundle bundle2 = new Bundle();
                bundle2.putString("tgl_kontrol", detailKontrolBayi.getTgl_Kembali_Bayi());
                bundle2.putString("keluhan", detailKontrolBayi.getKeluhan());
                bundle2.putString("vaksin", detailKontrolBayi.getVaksin().toString());
                bundle2.putString("tgl_vaksin", detailKontrolBayi.getTgl_Vaksin());
                bundle2.putString("keterangan", detailKontrolBayi.getKeterangan());
                bundle2.putString("tgl_kembali", detailKontrolBayi.getTgl_Kembali_Bayi());
                kontrolBayi.setArguments(bundle2);
                fragmentTransaction.replace(R.id.frame, kontrolBayi, "Detail Kontrol Bayi");
                fragmentTransaction.addToBackStack(null);
                this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                break;
            case Fungsi.DATA_ARTIKEL:
                break;
        }
        fragmentTransaction.commit();
    }


    public void btnOnklik(View view){
        Button clicked = (Button) view;
        switch (clicked.getId()){
            case R.id.button_proses:
                    prosess_hitung();
                break;
        }
    }

    private void prosess_hitung(){
        if(this.year!=0 && this.month!=0 && this.day!=0){
            Calendar calendar = Calendar.getInstance();
            calendar.set(this.year, this.month-1, this.day);
            calendar.add(Calendar.DATE, 280);
            Date date = calendar.getTime();
            this.year=1900+date.getYear();
            this.month=date.getMonth()+1;
            this.day=date.getDate();
            UtilityHelper.showAlert(this, "Perkiraan Kelahiran","Berdasarkan tanggal hamil kira-kira lahir pada "+String.valueOf(this.day)+"-"+String.valueOf(this.month)+"-"+String.valueOf(this.year));
        }
    }

    public void txtOnklik(View view){
        EditText clicked = (EditText) view;
        switch (clicked.getId()){
            case R.id.editText_Tgl_Hpht:
                    showDialog(this.CALENDAR);
                break;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==this.CALENDAR){
            Calendar calendar = Calendar.getInstance();
            return new DatePickerDialog(this, onDateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            showDate(i, i1+1, i2);
        }
    };

    private void showDate(int year, int month, int day){
        this.year = year;
        this.month= month;
        this.day = day;
        EditText date = (EditText) findViewById(R.id.editText_Tgl_Hpht);
        date.setText(String.valueOf(day)+"-"+String.valueOf(month)+"-"+String.valueOf(year));
    }

    @Override
    public void OnInternetTaskFailed(InternetTask internetTask) {
        UtilityHelper.showAlert(this, "CONNECTION ERROR!!!",internetTask.getException().getMessage());
    }
}
