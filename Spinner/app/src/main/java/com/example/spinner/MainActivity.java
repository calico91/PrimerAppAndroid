package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1,et2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.editTextNumber1);
        et2=(EditText) findViewById(R.id.editTextNumber2);
        tv=(TextView) findViewById(R.id.textViewResultado);
        spinner1=(Spinner) findViewById(R.id.spinner);

        String [] opciones ={"sumar","restar","multiplicar","dividir"};

    }
}