package first.program.bank1.data_Acces.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Account")
public class Account {
    @DatabaseField(allowGeneratedIdInsert = true)
    int AccountNumber;
    @DatabaseField(index = true, canBeNull = false)
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
