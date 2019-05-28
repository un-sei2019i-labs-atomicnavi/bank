package first.program.bank.data.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    pu
}
