package com.example.rubixsolving;

/**
 * Created by Sofie on 2017-03-16.
 */

public class Score {
    public int min;
    public int sec;
    public int mil;
    public int cube;

    public Score(int _min, int _sec, int _mil, int _cube){
        this.min = _min;
        this.sec = _sec;
        this.mil = _mil;
        this.cube = _cube;
    }

    @Override
    public String toString() {
        String minS = ( (min < 10) ? "0" + min: "" + min);
        String secS = ( (sec < 10) ? "0" + sec: "" + sec);
        String milS = ( (mil < 100) ? "0" + mil: "" + mil);

        return  minS + ":" + secS + ":" + milS;
    }
}
