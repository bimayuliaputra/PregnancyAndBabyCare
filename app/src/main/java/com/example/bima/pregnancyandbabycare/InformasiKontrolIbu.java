package com.example.bima.pregnancyandbabycare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.bima.pregnancyandbabycare.entities.KontrolIbu;
import com.example.bima.pregnancyandbabycare.lib.UtilityHelper;

public class InformasiKontrolIbu extends Fragment {

    public InformasiKontrolIbu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_informasi_kontrol_ibu, container, false);
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            EditText tgl_kontrol= (EditText) view.findViewById(R.id.editText_Tgl_Kontrol);
            EditText keluhan = (EditText) view.findViewById(R.id.editText_Keluhan);
            EditText tekanan_darah = (EditText) view.findViewById(R.id.editText_Tekanan_Darah);
            EditText berat_badan = (EditText) view.findViewById(R.id.editText_Berat_Badan);
            EditText umur_kehamilan = (EditText) view.findViewById(R.id.editText_Umur_Kehamilan);
            EditText tinggi_fundus = (EditText) view.findViewById(R.id.editText_Tinggi_Fundus);
            EditText letak_janin = (EditText) view.findViewById(R.id.editText_Letak_Janin);
            EditText denyut_jantung_janin = (EditText) view.findViewById(R.id.editText_Denyut_Jantung_Janin);
            EditText tindakan = (EditText) view.findViewById(R.id.editText_Tindakan);
            EditText nasehat = (EditText) view.findViewById(R.id.editText_Nasehat);
            EditText tgl_kelahiran = (EditText) view.findViewById(R.id.editText_Tgl_Htp);
            EditText tgl_kembali = (EditText) view.findViewById(R.id.editText_Tgl_Kembali);
            tgl_kontrol.setText(bundle.getString("tgl_kontrol"));
            keluhan.setText(bundle.getString("keluhan",""));
            tekanan_darah.setText(bundle.getString("tekanan_darah",""));
            berat_badan.setText(bundle.getString("berat_badan",""));
            umur_kehamilan.setText(bundle.getString("umur_kehamilan",""));
            tinggi_fundus.setText(bundle.getString("tinggi_fundus",""));
            letak_janin.setText(bundle.getString("letak_janin",""));
            denyut_jantung_janin.setText(bundle.getString("denyut_jantung_janin",""));
            tindakan.setText(bundle.getString("tindakan",""));
            nasehat.setText(bundle.getString("nasehat",""));
            tgl_kelahiran.setText(bundle.getString("tgl_kelahiran",""));
            tgl_kembali.setText(bundle.getString("tgl_kembali",""));
        }
        return view;
    }


}
