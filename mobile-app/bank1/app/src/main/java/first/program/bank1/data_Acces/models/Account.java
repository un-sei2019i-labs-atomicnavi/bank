package first.program.bank1.data_Acces.models;



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
