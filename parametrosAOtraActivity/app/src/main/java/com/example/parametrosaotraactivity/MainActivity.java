package com.example.parametrosaotraactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.ed1);
    }

    //metodo para el boton enviar
    public void Enviar(View view){
        //declaro la clase intent y le asigno los dos parametros, la vista donde estamos y a donde va
        Intent i = new Intent(this, MainActivity2.class);
        // envia el texto que recupera del edittex y lo pasa como string
        i.putExtra("dato",et1.getText().toString());
        // metodo para cambiar de una actividad a otra
        startActivity(i);
    }
}