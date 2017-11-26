package com.example.rubixsolving;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ScoresAdapter sAdapter2;
    ScoresAdapter sAdapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseProvider.setDB(this);
        final DBHandler db = databaseProvider.getDB();

        Button buttonStart2 = (Button) findViewById(R.id.buttonStart2by2);
        buttonStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Solves2by2Activity.class);
                startActivity(i);
            }
        });

        Button buttonStart3 = (Button) findViewById(R.id.buttonStart3by3);
        buttonStart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Solves3by3Activity.class);
                startActivity(i);
            }
        });

        // list 2 by 2 scores
        Button buttonUpdate2 = (Button) findViewById(R.id.buttonUpdate2by2);
        buttonUpdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Score> scores2 = db.findAndSortScores(2);
                if(scores2 != null)
                    sAdapter2.Update(scores2);
            }
        });
        Button buttonDelete2 = (Button) findViewById(R.id.buttonDelete2by2);
        buttonDelete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.removeScores(2);
            }
        });

        ArrayList<Score> scores2 = db.findAndSortScores(2);
        sAdapter2 = new ScoresAdapter(scores2);
        RecyclerView scoresView2 = (RecyclerView)findViewById(R.id.recyclerView_scores2by2);
        if(scores2.size() != 0)
            scoresView2.setAdapter(sAdapter2);

        // list 3 by 3 scores
        Button buttonUpdate3= (Button) findViewById(R.id.buttonUpdate3by3);
        buttonUpdate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Score> scores3 = db.findAndSortScores(3);
                if(scores3 != null)
                    sAdapter3.Update(scores3);
            }
        });
        Button buttonDelete3 = (Button) findViewById(R.id.buttonDelete3by3);
        buttonDelete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.removeScores(3);
            }
        });

        ArrayList<Score> scores3 = db.findAndSortScores(3);
        sAdapter3 = new ScoresAdapter(scores3);
        RecyclerView scoresView3 = (RecyclerView)findViewById(R.id.recyclerView_scores3by3);
        if(scores3.size() != 0)
            scoresView3.setAdapter(sAdapter3);
    }
}
