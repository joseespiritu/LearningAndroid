package com.example.rocas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ejecutar_info(View view){
        Intent i = new Intent(this,InfoClase.class);
        startActivity(i);
    }

    public void salirApp(View view){
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_en_activity, mimenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id = opcion_menu.getItemId();
        if(id==R.id.configuracion){
            return true;
        }

        if(id==R.id.info){
            ejecutar_info(null);
            return true;
        }

        return super.onOptionsItemSelected(opcion_menu);
    }
}