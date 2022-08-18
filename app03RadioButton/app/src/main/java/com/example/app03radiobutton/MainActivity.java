package com.example.app03radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv;
    private RadioButton rb1,rb2,rb3,rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 =(EditText) findViewById(R.id.editTextNumber1);
        et2 =(EditText) findViewById(R.id.editTextNumber2);
        tv =(TextView) findViewById(R.id.textView);
        rb1 =(RadioButton) findViewById(R.id.radioButton1);
        rb2 =(RadioButton) findViewById(R.id.radioButton2);
        rb3 =(RadioButton) findViewById(R.id.radioButton3);
        rb4 =(RadioButton) findViewById(R.id.radioButton4);
    }

    public void Calcular(View view) {
        int num1 = Integer.parseInt(et1.getText().toString());
        int num2 = Integer.parseInt(et2.getText().toString());
        int ope = 0;

        if (rb1.isChecked() == true) {// si el radiobutton esta selecionado entra
            ope = num1 + num2;
            String resultado = String.valueOf(ope);
            tv.setText(resultado);
        } else if (rb2.isChecked() == true) {
            ope = num1 - num2;
            String resultado = String.valueOf(ope);
            tv.setText(resultado);
        } else if (rb3.isChecked() == true) {
            ope = num1 * num2;
            String resultado = String.valueOf(ope);
            tv.setText(resultado);
        } else if (rb4.isChecked() == true) {
            if (num2 == 0) {
                Toast.makeText(this, "el segundo numero no puede ser 0", Toast.LENGTH_LONG).show();
            } else {
                ope = num1 / num2;
                String resultado = String.valueOf(ope);
                tv.setText(resultado);
            }
        }
    }
}