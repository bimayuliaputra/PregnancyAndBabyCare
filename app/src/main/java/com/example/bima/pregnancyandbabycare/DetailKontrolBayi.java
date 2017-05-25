package com.example.bima.pregnancyandbabycare;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class DetailKontrolBayi extends Fragment {

    public DetailKontrolBayi() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_kontrol_bayi, container, false);
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            EditText tgl_kontrol= (EditText) view.findViewById(R.id.editText_Tgl_Kontrol);
            EditText keluhan = (EditText) view.findViewById(R.id.editText_Keluhan);
            EditText vaksin = (EditText) view.findViewById(R.id.editText_Vaksin);
            EditText tgl_vaksin = (EditText) view.findViewById(R.id.editText_Tgl_Vaksin);
            EditText keterangan = (EditText) view.findViewById(R.id.editText_Keterangan);
            EditText tgl_kembali = (EditText) view.findViewById(R.id.editText_Tgl_Kembali);
            tgl_kontrol.setText(bundle.getString("tgl_kontrol"));
            keluhan.setText(bundle.getString("keluhan",""));
            vaksin.setText(bundle.getString("vaksin",""));
            tgl_vaksin.setText(bundle.getString("tgl_vaksin"));
            keterangan.setText(bundle.getString("keterangan"));
            tgl_kembali.setText(bundle.getString("tgl_kembali",""));
        }
        return view;
    }

}
