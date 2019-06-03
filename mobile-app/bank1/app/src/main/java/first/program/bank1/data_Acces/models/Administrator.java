package first.program.bank1.data_Acces.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Administrator{
    String name;
    int cedula;
    String password;
    public Administrator(String name,int cedula,String password){
        this.name=name;
        this.cedula=cedula;
        this.password=password;

    }


}
