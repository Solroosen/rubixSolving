package com.example.rubixsolving;

import android.content.Context;


public class databaseProvider {
    private static DBHandler db;

    public static void setDB(Context context){
        db = new DBHandler(context);
    }
    public static DBHandler getDB(){
        return db;
    }
}