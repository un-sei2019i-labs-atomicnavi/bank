package first.program.bank1.data_Acces.database;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import first.program.bank1.data_Acces.models.User;

public class Database extends OrmLiteSqliteOpenHelper {

    public static final String DATABASE_NAME = "bank.db";
    public static final int DATABASE_VERSION = 1;

    private Dao<User, Integer> UserDAO = null;
    private RuntimeExceptionDao<User,Integer>UserRuntimeDAO = null;

    public Database(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            logger.info(Database.class.getSimpleName(), "onCreate");
            TableUtils.clearTable(connectionSource, User.class);
        }catch(SQLException | java.sql.SQLException ex){
            logger.error(Database.class.getSimpleName(),"imposible crear base e datos",ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldV, int newV) {
       try {
           logger.info(Database.class.getSimpleName(), "onUpgrade");
           TableUtils.dropTable(connectionSource, User.class, true);
           onCreate(db, connectionSource);
       }catch(SQLException | java.sql.SQLException ex){
           logger.error(Database.class.getSimpleName(),"imposible eliminar base e datos",ex);
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
