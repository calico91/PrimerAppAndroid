package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
        ArrayAdapter <String> adaptadorSpinner=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        spinner1.setAdapter(adaptadorSpinner);//envia el spinner que se guardo en el arreglo al layaout
    }
    public void calcular(View view){
        int num1 = Integer.parseInt(et1.getText().toString());
        int num2 = Integer.parseInt(et2.getText().toString());
        int operacion =0;
        String resultado ="";

        String seleccion = spinner1.getSelectedItem().toString();
        switch (seleccion){
            case "sumar":
                //hace la operacion, la convierte en string y luego la envia al textview
                tv.setText(resultado =String.valueOf(operacion = num1+num2));
                break;
            case "restar":
                tv.setText(resultado =String.valueOf(operacion = num1-num2));
                break;
            case "multiplicar":
                tv.setText(resultado =String.valueOf(operacion = num1*num2));
                break;
            case "dividir":
                if (num2!=0) {
                    tv.setText(resultado =String.valueOf(operacion = num1/num2));
                }else{
                    Toast.makeText(this, "no se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}