package com.example.sharedpreferencesagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre,etDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre=(EditText)findViewById(R.id.et1);
        etDatos=(EditText)findViewById(R.id.et2);
    }

    //metodo para el boton guardar
    public void Guardar(View view){
        String  nombre =etNombre.getText().toString();
        String  datos =etDatos.getText().toString();

        //agenda = nombre de archivo
        SharedPreferences preferences=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor objEditor = preferences.edit();
        // datos que queremos guardar
        objEditor.putString(nombre,datos);
        // confirmar datos a guardar
        objEditor.commit();

        Toast.makeText(this,"el contacto se ah guardado",Toast.LENGTH_SHORT).show();
    }

    //metodo para el boton buscar
    public void Buscar(View view){
        String nombre = etNombre.getText().toString();

        SharedPreferences preferences=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = preferences.getString(nombre,"");

        if(datos.length()==0){
            Toast.makeText(this,"No se encontro ningun registro",Toast.LENGTH_SHORT).show();
        }else{
            etDatos.setText(datos);
        }
    }

    //metodo para boton limpiar
    public void Limpiar(View view){
        etNombre.setText("");
        etDatos.setText("");
    }
}
