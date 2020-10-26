package com.example.contador;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public int contador;

    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoResultado=(TextView)findViewById(R.id.contadorTexto);
        contador = 0;
    }

    public void incrementaContador(View vista){
        contador++;
        textoResultado.setText(""+contador);
        //mostrarResultado();
    }

    public void restaContador(View vista){
        contador--;

        if(contador<0) {
            CheckBox negativos = (CheckBox)findViewById(R.id.negativos);
            if(!negativos.isChecked()){
                contador=0;
            }
        }

        textoResultado.setText(""+contador);
        //mostrarResultado();
    }

    public void reseteaContador(View vista){
        EditText numero_reset = (EditText)findViewById(R.id.n_reseteo);

        try {
            contador = Integer.parseInt(numero_reset.getText().toString());
        } catch(Exception e){
            contador=0;
        }

        numero_reset.setText("");
        textoResultado.setText(""+contador);

        InputMethodManager miteclado = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        miteclado.hideSoftInputFromWindow(numero_reset.getWindowToken(),0);

        //mostrarResultado();
    }

    /*public void mostrarResultado(){
        TextView textoResultado = (TextView)findViewById(R.id.contadorTexto);
        textoResultado.setText("" + contador);
    }*/
}