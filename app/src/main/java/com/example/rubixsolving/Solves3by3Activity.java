package com.example.rubixsolving;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.view.View;

import java.util.Date;


public class Solves3by3Activity extends AppCompatActivity {

    Date startTime;
    Date endTime;
    ScoreHelp sh = new ScoreHelp();

    DBHandler db = databaseProvider.getDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solves);

        final Button buttonStart = (Button) findViewById(R.id.buttonSolveStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startTime==null) {
                    startTime = new Date();
                }

            }
        });

        Button buttonEnd = (Button) findViewById(R.id.buttonSolveEnd);
        buttonEnd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!(startTime==null) && endTime==null) {
                    endTime = new Date();
                    db.addScore(sh.saveTime(startTime, endTime, 3));
                    startTime = null;
                    endTime = null;
                }
            }
        });

        RecyclerView solvesView = (RecyclerView)findViewById(R.id.recyclerView_solves);
        solvesView.setAdapter(new SolvesAdapter());
    }
}
