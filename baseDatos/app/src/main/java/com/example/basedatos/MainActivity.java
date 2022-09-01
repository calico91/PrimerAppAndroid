package com.example.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etCodigo, etDescripcion, etPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCodigo=(EditText) findViewById(R.id.txtCodigo);
        etDescripcion=(EditText) findViewById(R.id.txtDescripcion);
        etPrecio=(EditText) findViewById(R.id.txtPrecio);
    }

    //metodo para registrar productos
    public void Registrar(View view){
        // administracion es el nombre de la bd
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"adminitracion",null,1);
        // se crea la conexion con la BD getWritableDatabase= metodo para lectura y escritura
        SQLiteDatabase BD = admin.getWritableDatabase();

        // guardo los datos de los edittex en variables
        String codigo = etCodigo.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        String precio = etPrecio.getText().toString();

        //si ningun de los campos estan vacios, entra
        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo",codigo);
            registro.put("descripcion",descripcion);
            registro.put("precio",precio);

            BD.insert("articulos",null,registro);
            BD.close();
            etCodigo.setText("");
            etDescripcion.setText("");
            etPrecio.setText("");

            Toast.makeText(this,"Regristro Exitoso",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Debes llenar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }
}