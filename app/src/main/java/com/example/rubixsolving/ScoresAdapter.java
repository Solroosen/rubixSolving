package com.example.rubixsolving;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;


public class ScoresAdapter extends RecyclerView.Adapter<ScoresViewHolder> {
    private ArrayList<Score> scoreDataset;

    public ScoresAdapter(ArrayList<Score> myDataset) {
        scoreDataset = myDataset;
    }

    public void Update(ArrayList<Score> scores) {
        scoreDataset = scores;
        notifyDataSetChanged();
    }

    @Override
    public ScoresViewHolder onCreateViewHolder(ViewGroup vg, int i){
        View v = LayoutInflater.from(vg.getContext()).inflate(R.layout.template_score, null);
        return new ScoresViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ScoresViewHolder holder, int i){
        Score score = scoreDataset.get(i);
        holder.tv.setText(score.toString());
    }
    @Override
    public int getItemCount(){
        return scoreDataset.size();
    }
}
