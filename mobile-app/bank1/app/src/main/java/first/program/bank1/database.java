package first.program.bank1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {
    public database(Context context) {
        super(context, "BANK.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table user(username text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");

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
}
