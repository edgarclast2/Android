package com.example.edgar.traductor;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
/**
 * Created by EDGAR on 28/07/2015.
 */
public class traductor extends MainActivity {
    private EditText et1,et2;
    private Cursor c;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traductor);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
    }
     //FUNCION DE INSERTAR

    public void ingresar(View v){

      AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd =admin.getWritableDatabase();
        //traemos la informacion
        String palabra1 = et1.getText().toString();
        String palabra2 = et2.getText().toString();
        //es una clase para guardar o contener los datos

        ContentValues registra  = new ContentValues();
        registra.put("palabra1",palabra1);
        registra.put("palabra2", palabra2);

        bd.insert("palabras", null, registra);
        bd.close();
        //para dejar limpio las cajas de texto
        et1.setText("");
        et2.setText("");
        Toast.makeText(this,"Se inserto la palabra",
                Toast.LENGTH_SHORT).show();
    }

    // para realizar la consulta devueve traduccion
    public void traducir(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //traemos la informacion
        //String palabra1 =et1.getText().toString();
        String[] pala1 =new String[] {et1.getText().toString()};
        //ContentValues registra  = new ContentValues();
        //registra.put("palabra1",palabra1);
        //creamos la consulta
         Cursor c =bd.rawQuery(
                 "select palabra2 from palabras where palabra1 =? "  , pala1);
         if (c.moveToFirst()){
             et2.setText(c.getString(0));
             Toast.makeText(this,"si Existe la traduccion de la palabra",
                     Toast.LENGTH_SHORT).show();
         } else
             Toast.makeText(this,"No Existe la traduccion de la palabra",
                     Toast.LENGTH_SHORT).show();
            bd.close();
    }

}
