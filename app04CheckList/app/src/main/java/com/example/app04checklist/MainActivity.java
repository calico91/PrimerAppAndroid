package com.example.app04checklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;
    private TextView tv;
    private CheckBox cbSuma,cbresta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.editTextNumber1);
        et2=(EditText) findViewById(R.id.editTextNumber2);
        tv=(TextView) findViewById(R.id.textView);
        cbSuma=(CheckBox) findViewById(R.id.checkBoxSuma);
        cbresta=(CheckBox) findViewById(R.id.checkBoxResta);
    }

    public void calcular(View view){
        int num1 = Integer.parseInt(et1.getText().toString());
        int num2 = Integer.parseInt(et2.getText().toString());
        String resultado="";
        int ope=0;
        if(cbSuma.isChecked()==true){
            ope = num1+num2;
            resultado= "La suma es: "+ope+"\n";
        }
        if(cbresta.isChecked()==true){
            ope=num1-num2;
            resultado= resultado + "La resta es: "+ope;
        }
        tv.setText(resultado);


    }
}