package first.program.bank1.data_Acces.repositories;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import first.program.bank1.R;
import first.program.bank1.data_Acces.database.Database;
import first.program.bank1.data_Acces.models.User;

public class AccountRepository extends BaseAdapter {

    Context context;
    Database db;
    ArrayList<User> users;

    public AccountRepository(Context context, Database db, ArrayList<User> users) {
        this.context = context;
        this.db = db;
        this.users = users;
    }

    public boolean createAccount(User user){
        SQLiteOpenHelper sqLiteOpenHelper = new SQLiteOpenHelper(context, "BANK.db", null, 1);
        SQLiteDatabase db = context.getWritableDatabase();
        ContentValues contentvalues= new ContentValues();
        contentvalues.put("username",user.getName());
        contentvalues.put("cedula",user.getCedula());
        contentvalues.put("password",user.getPassword());
        contentvalues.put("account",user.getAccount());
        long ver = db.insert("user",null,contentvalues);
        if (ver==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean getAccountById(){

    }
    public Boolean updateAccount(){

    }
    public boolean deleteAccount{

    }


}
