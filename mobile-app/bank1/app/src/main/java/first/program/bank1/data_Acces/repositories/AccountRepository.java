package first.program.bank1.data_Acces.repositories;

import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.Date;
import java.util.Iterator;

import first.program.bank1.data_Acces.database.Database;
import first.program.bank1.data_Acces.models.Account;
import first.program.bank1.data_Acces.models.Transaction;
import first.program.bank1.data_Acces.models.User;

public class AccountRepository {

    private final OrmLiteBaseActivity<Database> Oba;
    private int usuarioActual = 0;

    public AccountRepository(OrmLiteBaseActivity<Database> oba){
        this.Oba = oba;
    }

    public boolean chkAc(int id){
        if(Oba==null){
            Database db = Oba.getHelper();
            RuntimeExceptionDao<Account,Integer> dao = db.getAccountRuntimeDAO();
            if(dao.idExists(id))return true;
        } return false;

    }

    public void setUA(int a){
        usuarioActual = a;
    }
    public Boolean ChkUser(int id){
        if(Oba==null){
            Database db = Oba.getHelper();
            RuntimeExceptionDao<User,Integer> dao = db.getUserRuntimeDAO();
           if(dao.idExists(id))return true;
        } return false;
    }

    public Boolean Chkpss(int id,int pass){
        if(Oba==null){
            Database db = Oba.getHelper();
            RuntimeExceptionDao<User,Integer> dao = db.getUserRuntimeDAO();
            if(dao.idExists(id))return dao.queryForId(id).getPassword()==pass;
        } return false;
    }

    public String[] SA(){
        if(Oba==null){
            Database db = Oba.getHelper();
            RuntimeExceptionDao<User,Integer> dao = db.getUserRuntimeDAO();
            RuntimeExceptionDao<Account,Integer> daoA = db.getAccountRuntimeDAO();

            User n = dao.queryForId(usuarioActual);
            String[] s1=new String[4];
            s1[0] = "Name"+n.getName();
            s1[1] = "Cedula"+Integer.toString(n.getCedula());
            s1[2] = "Account"+Integer.toString(n.getAccount());
            s1[3] = "Balance"+Integer.toString(daoA.queryForId(n.getAccount()).getBalance());

            return s1;
        }else return null;

}
    public User getUserById(int user){
        if(Oba==null){
            Database db = Oba.getHelper();
            RuntimeExceptionDao<User,Integer> dao = db.getUserRuntimeDAO();
            User n = dao.queryForId(user);
            return n;
        }else return null;
    }

    public Boolean updateAccount(Account user){
        if(Oba==null){
            Database db = Oba.getHelper();
            RuntimeExceptionDao<Account,Integer> dao = db.getAccountRuntimeDAO();
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

    public boolean createUser(User user,int balance){
        if(Oba==null){
            Database db = Oba.getHelper();
            RuntimeExceptionDao<User,Integer> daoU = db.getUserRuntimeDAO();
            daoU.create(user);
            RuntimeExceptionDao<Account,Integer> daoA = db.getAccountRuntimeDAO();
            Account a1 = new Account(user.getAccount(),balance);
            daoA.create(a1);
            return true;
        }else return false;
    }

    public boolean createTransaction(int azzounti,int accounto,int amount){
        boolean b = false;
        if(Oba==null){
            Database db = Oba.getHelper();
            RuntimeExceptionDao<Account,Integer> daoA = db.getAccountRuntimeDAO();
            Account a1 = daoA.queryForId(azzounti);
            Account a2 = daoA.queryForId(accounto);
            if(daoA.idExists(a1.getAccountNumber()) &&  daoA.idExists(a2.getAccountNumber())) {
                if(a1.getBalance() <= amount) {
                    RuntimeExceptionDao<Transaction, Integer> daoT = db.getTransactionRuntimeDAO();
                    Date date = new Date(System.currentTimeMillis());
                    Transaction t1 = new Transaction(date, amount);
                    daoT.create(t1);
                    a1.setBalance(a1.getBalance()+amount);
                    a2.setBalance(a2.getBalance()-amount);
                    daoA.update(a1);
                    daoA.update(a2);
                    b = true;
                }else{
                    return b;
                }
            }else{
                return b;
            }
        }else {
            return b;
        }
        return b;

    }

}