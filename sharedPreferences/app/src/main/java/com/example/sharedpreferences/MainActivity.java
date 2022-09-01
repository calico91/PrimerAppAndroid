package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txtMail);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(preferences.getString("mail",""));
    }

    //metodo para el boton guardar
    public void Guardar(View view){
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //se edita el archivo preferencias por si se realiza algun cambio
        SharedPreferences.Editor objEditor = preferences.edit();
        //envia lo que el usuario escribio en el campo
        objEditor.putString("mail", et1.getText().toString());
        // confirma esa informacion que se envia y lo guarda
        objEditor.commit();
        finish();
    }
}