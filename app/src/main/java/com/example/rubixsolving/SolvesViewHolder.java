package com.example.rubixsolving;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

public class SolvesViewHolder extends RecyclerView.ViewHolder {

    ImageView iv;
    TextView tvName;
    TextView tvAlg;

    public SolvesViewHolder(View v){
        super(v);
        iv = (ImageView)v.findViewById(R.id.imageView);
        tvName = (TextView)v.findViewById(R.id.text_name);
        tvAlg = (TextView)v.findViewById(R.id.text_alg);

    }

}
