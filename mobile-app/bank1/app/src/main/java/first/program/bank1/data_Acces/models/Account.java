package first.program.bank1.data_Acces.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Account {

    int AccountNumber;
    int balance;
    public Account(int Account,int Balance) {
        this.AccountNumber=Account;
        this.balance=Balance;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
