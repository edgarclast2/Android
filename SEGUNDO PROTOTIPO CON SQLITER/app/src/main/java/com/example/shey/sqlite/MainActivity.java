package com.example.shey.sqlite;
import android.app.Activity;
//import android.support.v7.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
//DECLARAMOS NUESTRAS VARIABLES ET1,ET2
    //LOS UTILIZAREMO SOLO SERAN LA ET1,ET2
    private EditText et1, et2, et3, et4;
    private Cursor fila;


    //$$$$$$DERECHOS DE AUTOR$$$$$$$$:
    //&&&&&&EDGAR PINEDA CABRERA &&&&&
    //******UNIVERSIDAD JOSE MARIA ARGUEDAS******
    //*********INGENIERIA DE SISTEMAS*****

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et_dni);
        et2 = (EditText) findViewById(R.id.et_nombreyapellido);


    }


    //REALIZAR LAS FUNCIONES

    //FUNCION INSERTAR
    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String dni = et1.getText().toString();
        String nombre = et2.getText().toString();


        ContentValues registro = new ContentValues();  //es una clase para guardar datos

        registro.put("dni", dni);
        registro.put("nombre", nombre);


        bd.insert("votantes", null, registro);
        bd.close();

        et1.setText("");
        et2.setText("");


        Toast.makeText(this, "Se cargaron los datos de la persona",
                Toast.LENGTH_SHORT).show();
    }
//REALIZAR LA CONSULTA
public void consulta(View v) {
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
    SQLiteDatabase bd = admin.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.

   //TRAEMOS LA INFORMACION
   String dni = et1.getText().toString();

    Cursor fila = bd.rawQuery(  //devuelve 0 o 1 fila //es una consulta
            "select nombre  from votantes where dni='dni'"   , null);

    if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)
        et2.setText(fila.getString(0));
    } else
        Toast.makeText(this, "No existe una persona con dicho dni" ,
                Toast.LENGTH_SHORT).show();
    bd.close();
}


/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
