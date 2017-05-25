/*
package com.example.bima.pregnancyandbabycare;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

*/
/**
 * Created by FA on 3/26/2017.
 *//*


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private String[] mDataset;


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardview;
        public TextView mTextView;

        public MyViewHolder(View view){
            super(view);

            mCardview = (CardView) view.findViewById(R.id.card_view);
            */
/*mTextView = (TextView) view.findViewById(R.id.tvTitle);*//*

        }
    }

    public MyAdapter(String[] myDataset){
        mDataset = myDataset;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.mTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() { return mDataset.length; }
}
*/
