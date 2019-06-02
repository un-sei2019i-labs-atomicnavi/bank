package com.example.bank_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(usuario text primary key,pasword text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user ");
    }
    //inserting in database
    public boolean insert(String usuario, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("usuario",usuario );
        contentValues.put("password",password);
        long ins = db.insert("user",null,contentValues);
        if(ins==-1) return false;
        else return true;
    }
    //checking if email exists;
    public boolean chkusuario(String usuario){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{usuario});
        if(cursor.getCount()>0) return  false;
        else return true;
    }
    //cheking usuario y contraseña
    public boolean usuariopassword(String usuario,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=? and password=?",new String[]{usuario,password});
        if(cursor.getCount()>0) return  true;
        else return false;
    }

}
