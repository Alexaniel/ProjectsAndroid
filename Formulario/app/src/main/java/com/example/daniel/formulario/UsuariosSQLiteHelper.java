package com.example.daniel.formulario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSQLiteHelper extends SQLiteOpenHelper {
    //sentencia para crear una tabla
    String sqlCrearTabla = "CREATE TABLE Usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT,cedula INTEGER, nombre TEXT, apellido TEXT, correo TEXT)";
    public UsuariosSQLiteHelper(Context context, String nombre, CursorFactory factory, int version){
        super(context, nombre, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        //cuando se crea la base de datos se tiene que ejecutar la linea de comando para crear la tabla
        db.execSQL(sqlCrearTabla);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva){
        //generalmente se migra los datos de la tabla anterior a la nueva
        //por simplisidad se elimina la tabla anterior y se crea la nueva
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL(sqlCrearTabla);
    }
}
