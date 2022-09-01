package com.example.parametrosaotraactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1=(TextView) findViewById(R.id.tv1);
        //guardo en dato lo que tome de la actividad 1
        String dato = getIntent().getStringExtra("dato");
        // envio al tv la informacion para mostrar
        tv1.setText("hola "+dato);
    }

    //metodo para boton regresar
    public void Regresar(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }


}