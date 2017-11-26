package com.example.rubixsolving;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sofie on 2017-03-18.
 */

public class ScoreHelp {

    public Score saveTime(Date start, Date end, int cube){
        Date difference = compare(start, end);

        SimpleDateFormat m = new SimpleDateFormat("mm");
        SimpleDateFormat s = new SimpleDateFormat("ss");
        SimpleDateFormat l = new SimpleDateFormat("SSS");

        int min = Integer.parseInt(m.format(difference));
        int sec = Integer.parseInt(s.format(difference));
        int mil = Integer.parseInt(l.format(difference));

        return new Score(min, sec, mil, cube);

    }

    private Date compare(Date start, Date end){
        long startMil = start.getTime();
        long endMil = end.getTime();

        long dif = endMil - startMil;
        Date newD = new Date();
        newD.setTime(dif);
        return newD;

    }
}
