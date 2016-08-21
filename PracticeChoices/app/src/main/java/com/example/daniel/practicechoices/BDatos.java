package com.example.daniel.practicechoices;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Daniel on 20/8/2016.
 */

public class BDatos extends SQLiteOpenHelper{
    String sqlCrearTabla = "CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT,cedula TEXT, nombre TEXT, apellido TEXT, correo TEXT)";
    String sqlBorrarTabla = "DROP TABLE IF EXISTS usuarios";
    public BDatos(Context context) {
        super(context, "Usuario.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCrearTabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(sqlBorrarTabla);
        sqLiteDatabase.execSQL(sqlCrearTabla);
    }
}
