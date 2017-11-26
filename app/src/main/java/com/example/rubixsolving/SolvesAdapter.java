package com.example.rubixsolving;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SolvesAdapter extends RecyclerView.Adapter<SolvesViewHolder> {
    @Override
    public SolvesViewHolder onCreateViewHolder(ViewGroup vg, int i){
        View v = LayoutInflater.from(vg.getContext()).inflate(R.layout.template_solve, null);
        return new SolvesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SolvesViewHolder holder, int i){
        switch (i){
            case 0:
                holder.iv.setImageResource(R.drawable.sune);
                holder.tvName.setText("SUNE");
                holder.tvAlg.setText("(R U R') U (R U2 R')");
                break;
            case 1:
                holder.iv.setImageResource(R.drawable.antisune);
                holder.tvName.setText("ANTI-SUNE");
                holder.tvAlg.setText("(R' U' R) U' (R' U2 R)");
                break;
            case 2:
                holder.iv.setImageResource(R.drawable.car);
                holder.tvName.setText("CAR");
                holder.tvAlg.setText("F (R U R' U')(R U R' U')(R U R' U') F'");
                break;
            case 3:
                holder.iv.setImageResource(R.drawable.blinker);
                holder.tvName.setText("BLINKER");
                holder.tvAlg.setText("(R U2)(R2 U')(R2 U')(R2 U2 R)");
                break;
            case 4:
                holder.iv.setImageResource(R.drawable.headlights);
                holder.tvName.setText("HEADLIGHTS");
                holder.tvAlg.setText("(R2 D)(R' U2)(R D')(R' U2 R')");
                break;
            case 5:
                holder.iv.setImageResource(R.drawable.chameleon);
                holder.tvName.setText("CHAMELEON");
                holder.tvAlg.setText("(r U R' U')(r' F R F')");
                break;
            case 6:
                holder.iv.setImageResource(R.drawable.bowtie);
                holder.tvName.setText("BOWTIE");
                holder.tvAlg.setText("F' (r U R' U')(r' F R)");
                break;
            case 7:
                holder.iv.setImageResource(R.drawable.tperm);
                holder.tvName.setText("T-PERM");
                holder.tvAlg.setText("(R U R' U')(R' F)(R2 U' R') U' (R U R' F')");
                break;
            case 8:
                holder.iv.setImageResource(R.drawable.yperm);
                holder.tvName.setText("Y-PERM");
                holder.tvAlg.setText("F R U' R' U' (R U R' F')(R U R' U')(R' F R F')");
                break;
            case 9:
                holder.iv.setImageResource(R.drawable.cw_edge_3cycle);
                holder.tvName.setText("CW EDGE 3-CYCLE");
                holder.tvAlg.setText("(R2 U (R U R' U')(R' U')(R' U R')");
                break;
            case 10:
                holder.iv.setImageResource(R.drawable.ccw_edge_3cycle);
                holder.tvName.setText("CCW EDGE 3-CYCLE");
                holder.tvAlg.setText("(R U')(R U)(R U)(R U')(R' U' R2)");
                break;
            case 11:
                holder.iv.setImageResource(R.drawable.hperm);
                holder.tvName.setText("H-PERM");
                holder.tvAlg.setText("(M2 U' M2) U2 (M2 U' M2)");
                break;
            case 12:
                holder.iv.setImageResource(R.drawable.zperm);
                holder.tvName.setText("Z-PERM");
                holder.tvAlg.setText("(M2 U' M2) U' (M' U2) M2 U2 (M' U2)");
                break;
        }
    }

    @Override
    public int getItemCount(){
        return 13;
    }


}
