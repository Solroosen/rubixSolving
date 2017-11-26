package com.example.rubixsolving;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Sofie on 2017-03-17.
 */

public class ScoresViewHolder extends RecyclerView.ViewHolder {

    TextView tv;
    public ScoresViewHolder(View v) {
        super(v);
        tv = (TextView) v.findViewById(R.id.score);
    }
}
