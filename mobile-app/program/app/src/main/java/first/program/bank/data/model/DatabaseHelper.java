package first.program.bank.data.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME= "bank";
    private static final String COL_01="nombre ,";
    private static final String COL_02="cedula o id";
    private static final String COL_03="clave ,";
    private static final String COL_04="cuenta ,";
    public DatabaseHelper(Context context){
        super(context,TABLE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
            String createTable = "CREATE TABLE " + TABLE_NAME +"( "+COL_01+"cedula PRIMARY KEY,"+COL_03+COL_04+"TEXT)";
            db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("DROP TABLE if EXISTS "+ TABLE_NAME);
         onCreate(db);
    }
    public boolean addData(String nombre,String cedula,String clave,String cuenta){
     SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_01,nombre);
        contentValues.put(COL_02,cedula);
        contentValues.put(COL_03,clave);
        contentValues.put(COL_04,cuenta);
        Log.d(nombre , "addData: Adding" + nombre + "to "+ TABLE_NAME);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }

    }
}
