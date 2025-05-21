package com.example.proyecto_aplicaciones_moviles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "menuDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE items(id INTEGER PRIMARY KEY, name TEXT, category TEXT, price REAL)");
        db.execSQL("CREATE TABLE cart(id INTEGER PRIMARY KEY AUTOINCREMENT, item_id INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
