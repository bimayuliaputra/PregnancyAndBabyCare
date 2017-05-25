package com.example.bima.pregnancyandbabycare.lib;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bima.pregnancyandbabycare.R;
import com.example.bima.pregnancyandbabycare.entities.DataArtikel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by RAHMA on 5/23/2017.
 */

public class ArtikelAdapter extends ArrayAdapter<DataArtikel>{
    Context context;
    List<DataArtikel> dataArtikels;

    public ArtikelAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<DataArtikel> objects) {
        super(context, resource, objects);
        this.context=context;
        this.dataArtikels = objects;
    }

    @Override
    public int getCount() {
        if(dataArtikels!=null){
            return dataArtikels.size();
        }else{
            return 0;
        }
    }

    @Nullable
    @Override
    public DataArtikel getItem(int position) {
        if(dataArtikels!=null){
            return dataArtikels.get(position);
        }else{
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        if(dataArtikels!=null){
            return dataArtikels.get(position).hashCode();
        }else{
            return 0;
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder;
        if(convertView==null){
            holder = new Holder();
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.article_item, null);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imgArticle);
            holder.textView = (TextView) convertView.findViewById(R.id.editText_Judul);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        DataArtikel dataArtikel = getItem(position);
        holder.textView.setText(dataArtikel.getJudul());
        Picasso.with(getContext()).load(dataArtikel.getFoto()).resize(100,100).into(holder.imageView);
        return convertView;
    }

    private class Holder{
        TextView textView;
        ImageView imageView;
    }
}
