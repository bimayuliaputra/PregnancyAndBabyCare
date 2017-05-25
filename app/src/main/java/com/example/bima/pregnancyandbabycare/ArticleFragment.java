package com.example.bima.pregnancyandbabycare;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bima.pregnancyandbabycare.entities.DataArtikel;
import com.example.bima.pregnancyandbabycare.lib.ArtikelAdapter;
import com.example.bima.pregnancyandbabycare.lib.UtilityHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment implements AdapterView.OnItemClickListener {
    ArrayList<DataArtikel> dataArtikels;

    public ArticleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_article,container, false);
        Bundle bundle= this.getArguments();
        if(bundle!=null){
            try {
                JSONObject jsonObject = new JSONObject(bundle.getString("response"));
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                dataArtikels = new ArrayList<>();
                for (int i =0;i<jsonArray.length();i++){
                    dataArtikels.add(new DataArtikel(jsonArray.getJSONObject(i)));
                }
                ArtikelAdapter artikelAdapter = new ArtikelAdapter(getContext(), R.layout.article_item, dataArtikels);
                ListView listView = (ListView) rootView.findViewById(R.id.list_artikel);
                listView.setAdapter(artikelAdapter);
                listView.setOnItemClickListener(this);
            }catch (Exception e){
                UtilityHelper.showAlert(this.getContext(), "ERROR!!!",e.getMessage());
            }
        }
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        DetailArtikel detailArtikel = new DetailArtikel();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, detailArtikel, "fragment2");
        Bundle bundle = new Bundle();
        bundle.putString("judul",dataArtikels.get(i).getJudul());
        bundle.putString("foto",dataArtikels.get(i).getFoto());
        bundle.putString("text",dataArtikels.get(i).getIsi());
        detailArtikel.setArguments(bundle);
        fragmentTransaction.commit();
    }
}