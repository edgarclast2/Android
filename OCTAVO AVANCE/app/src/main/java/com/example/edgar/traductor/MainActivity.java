package com.example.edgar.traductor;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Activity;
import android.widget.ImageButton;


public class MainActivity extends Activity {
  private MediaPlayer mp;
    private ImageButton btnsonido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       //lanza el menu
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
btnsonido = (ImageButton)findViewById(R.id.imageButton);
btnsonido.setOnClickListener(new View.OnClickListener(){
    public void onClick(View view){
        mp = MediaPlayer.create(MainActivity.this,R.raw.sonido1);
        mp.start();
    }

});

//++++++++++++++++++++EDGAR PINEDA CABRERA+++++++++++++
        //+++++++++++UNIVERSIDAD NACIONAL JOSE MARIA ARGUEDAS++++++++++++++++
        //**************INGENIERIA DE SISTEMAS*****************

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {



        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void lanzartraductor(View view){
        Intent i=new Intent(this,traductor.class );
        startActivity(i);
    }

   /* @Override
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
