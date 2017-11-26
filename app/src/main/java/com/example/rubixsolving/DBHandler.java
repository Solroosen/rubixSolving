package com.example.rubixsolving;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Time;
import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // All static variables
    // Database version
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "rubixSolve";

    // table name
    private static final String TABLE_SCORES = "scores";

    // players table column names
    private static final String COLUMN_SID = "p_id";
    private static final String COLUMN_CUBE = "score_cube";
    private static final String COLUMN_SCORE_MIN = "score_min";
    private static final String COLUMN_SCORE_SEC = "score_sec";
    private static final String COLUMN_SCORE_MIL = "score_mil";


    // score table statement
    private static final String CREATE_SCORE_TABLE = "CREATE TABLE " + TABLE_SCORES + "("
            + COLUMN_SID + " INTEGER PRIMARY KEY, "
            + COLUMN_CUBE + " INTEGER, "
            + COLUMN_SCORE_MIN + " INTEGER, "
            + COLUMN_SCORE_SEC + " INTEGER, "
            + COLUMN_SCORE_MIL + " INTEGER "
            + ")";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // creating tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SCORE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
        // Create tables again
        onCreate(db);
    }

    public void dropTables(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
        // Create tables again
        onCreate(db);
    }

    public boolean removeScores(int cube) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_SCORES, COLUMN_CUBE + " = " + cube, null) > 0;
    }

    public void addScore(Score score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CUBE, score.cube);
        values.put(COLUMN_SCORE_MIN, score.min);
        values.put(COLUMN_SCORE_SEC, score.sec);
        values.put(COLUMN_SCORE_MIL, score.mil);
        db.insert(TABLE_SCORES, null, values);
        db.close(); // Closing database connection
    }

    //public ArrayList<Score> findScores() {
    //    SQLiteDatabase db = this.getReadableDatabase();
    //    String q = "SELECT * FROM " + TABLE_SCORES;
    //    Cursor cursor = db.rawQuery(q, null);
    //    ArrayList<Score> scores = cursorToArray(cursor);
    //    db.close();
    //    return scores;
    //}

    public ArrayList<Score> findAndSortScores(int cube) {
        SQLiteDatabase db = this.getReadableDatabase();
        String q = "SELECT * FROM " + TABLE_SCORES +
                " WHERE " + COLUMN_CUBE + " = " + cube +
                " ORDER BY " + COLUMN_SCORE_MIN + " ASC, " + COLUMN_SCORE_SEC + " ASC, " + COLUMN_SCORE_MIL + " ASC";
        Cursor cursor = db.rawQuery(q, null);
        ArrayList<Score> scores = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                scores.add(
                        new Score(
                                Integer.parseInt(cursor.getString(2)),
                                Integer.parseInt(cursor.getString(3)),
                                Integer.parseInt(cursor.getString(4)),
                                Integer.parseInt(cursor.getString(1))
                        ));
            } while (cursor.moveToNext());
        }
        db.close();
        return scores;
    }

    public ArrayList<Score> findAndSort3by3Scores() {
        SQLiteDatabase db = this.getReadableDatabase();
        String q = "SELECT * FROM " + TABLE_SCORES +
                " WHERE " + COLUMN_CUBE + " = " + 3 +
                " ORDER BY " + COLUMN_SCORE_MIN + " ASC, " + COLUMN_SCORE_SEC + " ASC, " + COLUMN_SCORE_MIL + " ASC";
        Cursor cursor = db.rawQuery(q, null);
        ArrayList<Score> scores = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                scores.add(
                        new Score(
                                Integer.parseInt(cursor.getString(2)),
                                Integer.parseInt(cursor.getString(3)),
                                Integer.parseInt(cursor.getString(4)),
                                Integer.parseInt(cursor.getString(1))
                        ));
            } while (cursor.moveToNext());
        }
        db.close();
        return scores;
    }

    private ArrayList<Score> cursorToArray(Cursor cursor) {
        ArrayList<Score> scores = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                scores.add(
                        new Score(
                                Integer.parseInt(cursor.getString(1)),
                                Integer.parseInt(cursor.getString(2)),
                                Integer.parseInt(cursor.getString(3)),
                                Integer.parseInt(cursor.getString(4))
                        ));
            } while (cursor.moveToNext());
        }
        return scores;
    }

}


