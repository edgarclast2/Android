package com.example.shey.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
//LAMAMOS AL CONSTRUCTOR
    public AdminSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
//CREAMOS LA TABLA
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table votantes(dni text, nombre text)");
            }
//BORRAR LA TABLA Y CREAR LA NUEVA TABLA

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists votantes");
        db.execSQL("create table votantes(dni text, nombre text)");
    }
}
