package com.example.bima.pregnancyandbabycare;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bima.pregnancyandbabycare.lib.FormData;
import com.example.bima.pregnancyandbabycare.lib.Fungsi;
import com.example.bima.pregnancyandbabycare.lib.InternetHelper;
import com.example.bima.pregnancyandbabycare.lib.InternetTask;
import com.example.bima.pregnancyandbabycare.lib.OnInternetTaskFinishedListener;
import com.example.bima.pregnancyandbabycare.lib.UtilityHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class PregnancyFragment extends Fragment  {
    private ListView list_hamil;

    public PregnancyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pregnancy, container, false);
    }

}
