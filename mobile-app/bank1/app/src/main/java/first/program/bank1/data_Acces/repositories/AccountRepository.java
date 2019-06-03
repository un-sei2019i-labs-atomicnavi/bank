package first.program.bank1.data_Acces.repositories;


import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.ArrayList;

import first.program.bank1.R;
import first.program.bank1.data_Acces.database.Database;
import first.program.bank1.data_Acces.models.User;

public class AccountRepository extends OrmLiteSqliteOpenHelper {

    public static final String DATABASE_NAME = "bank.db";
    public static final int DATABASE_VERSION = 1;

    private Dao<User, Integer> UserDAO = null;
    private RuntimeExceptionDao<User,Integer>UserRuntimeDAO = null;

    public AccountRepository(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    /*public boolean createAccount(User user){
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
    }*/
    public Boolean getAccountById(){
    return true;
    }
    public Boolean updateAccount(){
    return true;
    }
    public boolean deleteAccount(){
        return true;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            logger.info(AccountRepository.class.getSimpleName(), "onCreate");
            TableUtils.clearTable(connectionSource, User.class);
        }catch(SQLException | java.sql.SQLException ex){
            logger.error(AccountRepository.class.getSimpleName(),"imposible crear base e datos",ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldV, int newV) {
       try {
           logger.info(AccountRepository.class.getSimpleName(), "onUpgrade");
           TableUtils.dropTable(connectionSource, User.class, true);
           onCreate(db, connectionSource);
       }catch(SQLException | java.sql.SQLException ex){
           logger.error(AccountRepository.class.getSimpleName(),"imposible eliminar base e datos",ex);
           throw new RuntimeException(ex);
       }
    }

    public Dao<User, Integer> getUserDAO() throws java.sql.SQLException {
        if(UserDAO==null)UserDAO = getDao(User.class);
        return UserDAO;
    }

    public void setUserDAO(Dao<User, Integer> userDAO) {
        UserDAO = userDAO;
    }

    public RuntimeExceptionDao<User, Integer> getUserRuntimeDAO() {
        if(UserRuntimeDAO==null)UserRuntimeDAO = getRuntimeExceptionDao(User.class);
        return UserRuntimeDAO;
    }

    public void setUserRuntimeDAO(RuntimeExceptionDao<User, Integer> userRuntimeDAO) {
        UserRuntimeDAO = userRuntimeDAO;
    }

    @Override
    public void close() {
        super.close();
        UserDAO = null;
        UserRuntimeDAO = null;

    }
}
