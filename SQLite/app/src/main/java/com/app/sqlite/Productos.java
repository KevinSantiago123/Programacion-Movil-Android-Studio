package com.app.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.ScriptIntrinsicYuvToRGB;

public class Productos extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE Productos (Codigo INTEGER, Descripcion TEXT, Presentacion TEXT, ValorUnidad INTEGER)";

    public Productos (Context conext, String nombre,
                      SQLiteDatabase.CursorFactory factory, int version) {
        super(conext, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Productos");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
