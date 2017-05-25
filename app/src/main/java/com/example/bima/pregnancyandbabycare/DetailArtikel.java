package com.example.bima.pregnancyandbabycare;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailArtikel extends Fragment {
    public DetailArtikel() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_detail_artikel, container, false);
        TextView judul = (TextView) view.findViewById(R.id.text_Judul);
        TextView isi = (TextView) view.findViewById(R.id.isi);
        Bundle bundle = getArguments();
        judul.setText(bundle.getString("judul"));
        isi.setText(Html.fromHtml(bundle.getString("text")));
        return  view;
    }
}
