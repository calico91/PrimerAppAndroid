package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etn, etp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn=(EditText) findViewById(R.id.txtNombre);
        etp=(EditText) findViewById(R.id.txtPass);
    }

    //metodo para el boton
    public void Registrar(View view){
        String nombre = etn.getText().toString();
        String password = etp.getText().toString();

        
    }
}