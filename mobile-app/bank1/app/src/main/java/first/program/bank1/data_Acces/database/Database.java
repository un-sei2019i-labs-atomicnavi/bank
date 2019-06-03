package first.program.bank1.data_Acces.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public static final String NAME = "Database";
    public static final int VERSION = 1;

    public Database(Context context) {
        super(context, "BANK.db", null, 1);
    }

    //crea la tabla de usuarios
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

    // agrega a la base de datos

    public boolean insert(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues= new ContentValues();
        contentvalues.put("username",username);
        contentvalues.put("password",password);
        long ver = db.insert("user",null,contentvalues);
        if (ver==-1){
            return false;
        }else{
            return true;
        }
    };
    // verifica si existe el usuario
    public boolean chckuser( String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=?",new String[]{username});
        if(cursor.getCount()>0)return false;
        else return true;

    }
    //verificacion de usuario y contrasena
    public boolean chckpass(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0)return true;
        else return false;
    }
}
