package com.example.edgar.traductor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by EDGAR on 29/07/2015.
 */
class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
   //constructor
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table palabras(id integer primary key autoincrement, palabra1 text, palabra2 text)");
    }
// borrar tabla
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionPosterior) {
       db.execSQL("drop table if exists palabras");
        db.execSQL("create table palabras(id integer primary key autoincrement, palabra1 text, palabra2 text)");
    }
}
