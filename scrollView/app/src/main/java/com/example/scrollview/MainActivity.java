package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Seleccion(View view){
        switch (view.getId()) {
            case R.id.fresa:
                Toast.makeText(this, "Estas son fresas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.banano:
                Toast.makeText(this, "Estas son bananos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.uvas:
                Toast.makeText(this, "Estas son uvas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cereza:
                Toast.makeText(this, "Estas son cerezas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.franbueza:
                Toast.makeText(this, "Estas son franbuezas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.kiwi:
                Toast.makeText(this, "Estas son kiwis", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mango:
                Toast.makeText(this, "Estas son mangos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.manzana:
                Toast.makeText(this, "Estas son manzanas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.melo:
                Toast.makeText(this, "Estas son melones", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mora:
                Toast.makeText(this, "Estas son moras", Toast.LENGTH_SHORT).show();
                break;
            case R.id.naranja:
                Toast.makeText(this, "Estas son naranjas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pera:
                Toast.makeText(this, "Estas son peras", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sandia:
                Toast.makeText(this, "Estas son sandias", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pina:
                Toast.makeText(this, "Estas son Pinas", Toast.LENGTH_SHORT).show();
                break;
        }



        }
    }