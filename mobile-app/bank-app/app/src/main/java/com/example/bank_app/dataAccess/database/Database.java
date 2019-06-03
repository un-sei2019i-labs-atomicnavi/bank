package com.example.bank_app.dataAccess.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{
    public Database(Context context) {
        super(context, "Login.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table User(username text,cedula int primary key, password text,account int )");
        db.execSQL("Create table Account(Account int primary key, Balance int)");
        db.execSQL("Create table Administrator(username text,cedula int primary key, password text)");
        db.execSQL("Create table Transactions(fecha date ,id int primary key, ammount int,accountIn int,accountOut int )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
        db.execSQL("drop table if exists Account");
        db.execSQL("drop table if exists Administrator");
        db.execSQL("drop table if exists Transactions");

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
