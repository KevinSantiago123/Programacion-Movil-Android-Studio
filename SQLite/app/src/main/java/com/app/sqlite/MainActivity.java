package com.app.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button insertar, consultar, actualizar, eliminar;
    TextView codigo, descripcion, presentacion, valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertar = (Button)findViewById(R.id.insertar);
        consultar = (Button)findViewById(R.id.consultar);
        actualizar = (Button)findViewById(R.id.actualizar);
        eliminar = (Button)findViewById(R.id.eliminar);

        codigo = (TextView)findViewById(R.id.codigo);
        descripcion = (TextView)findViewById(R.id.descripcion);
        presentacion = (TextView)findViewById(R.id.presentacion);
        valor = (TextView)findViewById(R.id.unidad);

        insertar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Productos productos = new Productos(getApplicationContext(), "DBInventarios", null,1);
                SQLiteDatabase db = productos.getWritableDatabase();
                if (db != null) {
                    String cod = codigo.getText().toString();
                    String des = descripcion.getText().toString();
                    String pre = presentacion.getText().toString();
                    String val = valor.getText().toString();
                    db.execSQL("INSERT INTO Productos Values('" + cod + "','" + des + "','" + pre + "','" + val + "')");
                    db.close();
                    Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error al abrir la base de datos", Toast.LENGTH_LONG).show();
                }
            }
        });

        consultar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Productos productos = new Productos(getApplicationContext(), "DBInventarios", null,1);
                SQLiteDatabase db = productos.getReadableDatabase();
                Cursor c = db.rawQuery("SELECT * FROM Productos WHERE Codigo='" +
                        codigo.getText().toString() + "'", null);
                if (c.moveToFirst()) {
                    descripcion.setText(c.getString(1));
                    presentacion.setText(c.getString(2));
                    valor.setText(c.getString(3));
                } else {
                    Toast.makeText(getApplicationContext(), "No hay coincidencias", Toast.LENGTH_LONG).show();
                }

            }
        });
        actualizar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Productos productos = new Productos(getApplicationContext(), "DBInventarios", null,1);
                SQLiteDatabase db = productos.getWritableDatabase();
                db.execSQL("UPDATE Productos SET Descripcion='" + descripcion.getText().toString() + "', " +
                        "Presentacion='" + presentacion.getText().toString() +
                        "', ValorUnidad='" + valor.getText().toString() + "'WHERE Codigo='" +
                        codigo.getText().toString() + "'"
                );
                db.close();
                Toast.makeText(getApplicationContext(), "Registro actualizado exitosamente", Toast.LENGTH_LONG).show();
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Productos productos = new Productos(getApplicationContext(), "DBInventarios", null,1);
                SQLiteDatabase db = productos.getWritableDatabase();
                db.execSQL("DELETE FROM Productos WHERE Codigo='" + codigo.getText().toString() + "'");
                db.close();
                Toast.makeText(getApplicationContext(), "Registro eliminado correctamente", Toast.LENGTH_LONG).show();
                codigo.setText("");
                descripcion.setText("");
                presentacion.setText("");
                valor.setText("");
            }
        });


    }
}