package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyHelper extends SQLiteOpenHelper {
    private static final String databaseName="DictionaryDB";
    private static final int dbVersion=1;
    private static final String tblWord="tblWord";
    private static final String WordID="WordId";
    private static final String Word="Word";
    private static final String Meaning="Meaning";

    public MyHelper(Context context){
        super(context,databaseName,null,dbVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+ tblWord + "(" + WordID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Word + " TEXT," + Meaning + " TEXT " + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean InsertData(String word,String meaning,SQLiteDatabase db){
        try{
            String query="insert into tblWord(Word,Meaning) values('" + word + "','" + meaning + "')";
            db.execSQL(query);
            return true;
        }
        catch (Exception e){
            Log.d("Error : ", e.toString());
            return false;
        }
    }
}
