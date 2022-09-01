package com.example.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
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

        etCodigo = (EditText) findViewById(R.id.txtCodigo);
        etDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        etPrecio = (EditText) findViewById(R.id.txtPrecio);
    }

    //metodo para registrar productos
    public void Registrar(View view) {
        // se instancia un objeto de  la clase que se creo donde tenemos la bd
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "adminitracion",
                null, 1);
        // se crea la conexion con la BD getWritableDatabase= metodo para lectura y escritura
        SQLiteDatabase BD = admin.getWritableDatabase();

        // guardo los datos de los edittex en variables
        String codigo = etCodigo.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        String precio = etPrecio.getText().toString();

        //si ningun de los campos estan vacios, entra
        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            BD.insert("articulos", null, registro);
            BD.close();
            etCodigo.setText("");
            etDescripcion.setText("");
            etPrecio.setText("");

            Toast.makeText(this, "Regristro Exitoso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Debes llenar todos los campos",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // metodo para consultar un articulo
    public void Buscar(View view) {
        // se instancia un objeto de  la clase que se creo donde tenemos la bd
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "adminitracion",
                null, 1);
        // se crea la conexion con la BD getWritableDatabase= metodo para lectura y escritura
        SQLiteDatabase BD = admin.getWritableDatabase();

        // guardo los datos de los edittex en variables
        String codigo = etCodigo.getText().toString();

        if (!codigo.isEmpty()) {
            // Cursor ayuda al seleccionar un producto con su codigo
            Cursor fila = BD.rawQuery("select descripcion,precio from articulos " +
                    " where codigo=" + codigo, null);

            //revisa si la consulta tiene datos
            if (fila.moveToFirst()) {
                //primer valor siempre es 0, ya es a eleccion que datos quiero mostrar
                etDescripcion.setText(fila.getString(0));
                etPrecio.setText(fila.getString(1));
                BD.close();
            } else {
                Toast.makeText(this, "Producto no existe", Toast.LENGTH_SHORT).show();
                BD.close();
            }

        } else {
            Toast.makeText(this, "Debes ingresar el codigo del producto",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // eliminar articulos
    public void Eliminar(View view) {
        // se instancia un objeto de  la clase que se creo donde tenemos la bd
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "adminitracion",
                null, 1);
        // se crea la conexion con la BD getWritableDatabase= metodo para lectura y escritura
        SQLiteDatabase BD = admin.getWritableDatabase();

        String codigo = etCodigo.getText().toString();

        if(!codigo.isEmpty()){
            //delete retorna un entero y lo guardamos en cantidad
            int cantidad=BD.delete("articulos","codigo="+codigo,null);
            BD.close();

            etPrecio.setText("");
            etDescripcion.setText("");
            etPrecio.setText("");

            if (cantidad!=0){
                Toast.makeText(this, "Se elimino el registro numero"+codigo,
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "el articulo "+codigo+"no existe",
                        Toast.LENGTH_SHORT).show();
            }


        }else{
            Toast.makeText(this, "Ingresar el codigo del articulo",
                    Toast.LENGTH_SHORT).show();
        }
    }
    //metodo para modificar
    public void Modificar(View view) {
        // se instancia un objeto de  la clase que se creo donde tenemos la bd
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "adminitracion",
                null, 1);
        // se crea la conexion con la BD getWritableDatabase= metodo para lectura y escritura
        SQLiteDatabase BD = admin.getWritableDatabase();

        // guardo los datos de los edittex en variables
        String codigo = etCodigo.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        String precio = etPrecio.getText().toString();

        //si ningun de los campos estan vacios, entra
        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()) {

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            //update retorna un entero y lo guardamos en cantidad
            int cantidad=BD.update("articulos",registro,"codigo="+codigo,null);
            BD.close();

            if(cantidad!=0){
                Toast.makeText(this, "el articulo "+codigo+" se modifico correctamente",
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "el articulo "+codigo+" no existe",
                        Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Ingresar el codigo del articulo",
                    Toast.LENGTH_SHORT).show();
        }
        }
        //limpiar
        public void Limpiar(View view){
            etPrecio.setText("");
            etDescripcion.setText("");
            etCodigo.setText("");
        }
}