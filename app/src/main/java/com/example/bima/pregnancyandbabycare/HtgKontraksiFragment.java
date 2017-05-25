package com.example.bima.pregnancyandbabycare;


import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class HtgKontraksiFragment extends Fragment {
    Button btn_start, btn_reset;
    TextView waktu;
    ListView listWaktu;
    View  view;
    Handler handler;
    ArrayList<String> listWaktus;
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;
    int Seconds, Minutes, MilliSeconds;

    public HtgKontraksiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view =inflater.inflate(R.layout.fragment_htg_kontraksi, container, false);
        initComponents();
        setListener();
        return this.view;
    }

    private void initComponents(){
        btn_reset = (Button) view.findViewById(R.id.button_reset);
        btn_start = (Button) view.findViewById(R.id.button_start);
        listWaktu = (ListView) view.findViewById(R.id.listWaktu);
        waktu   = (TextView) view.findViewById(R.id.text_Waktu);
        handler = new Handler();
        listWaktus = new ArrayList<>();
    }

    private void setListener(){
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
            }
        });
    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            MillisecondTime = SystemClock.uptimeMillis() - StartTime;
            UpdateTime = TimeBuff + MillisecondTime;
            Seconds = (int) (UpdateTime/1000);
            Minutes = Seconds/60;
            Seconds = Seconds % 60;
            MilliSeconds = (int) (UpdateTime % 1000);
            waktu.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }
    };

}