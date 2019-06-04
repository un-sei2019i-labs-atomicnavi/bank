package first.program.bank1.data_Acces.repositories;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import first.program.bank1.data_Acces.database.Database;
import first.program.bank1.data_Acces.models.User;

public class AccountRepository {

    private final OrmLiteBaseActivity<Database> Oba;

    public AccountRepository(OrmLiteBaseActivity<Database> oba){
        this.Oba = oba;
    }


    public User getAccountById(int user){
        if(Oba==null){
            Database db = Oba.getHelper();
            RuntimeExceptionDao<User,Integer> dao = db.getUserRuntimeDAO();
            User n = dao.queryForId(user);
            return n;
        }else return null;
    }
    public Boolean updateAccount(User user){
        if(Oba==null){
            Database db = Oba.getHelper();
            RuntimeExceptionDao<User,Integer> dao = db.getUserRuntimeDAO();
            dao.update(user);
            return true;
        }else return false;
    }
    public boolean deleteAccount(User user){
        if(Oba==null){
            Database db = Oba.getHelper();
            RuntimeExceptionDao<User,Integer> dao = db.getUserRuntimeDAO();
            dao.delete(user);
            return true;
        }else return false;
    }

    public boolean createAccount(User user){
        if(Oba==null){
            Database db = Oba.getHelper();
            RuntimeExceptionDao<User,Integer> dao = db.getUserRuntimeDAO();
            dao.create(user);
            return true;
        }else return false;
    }

}