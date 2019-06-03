package first.program.bank1.data_Acces.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class Transaction{
    int id;
    Date date;
    int amount;
    public Transaction(int id,Date date,int ammount) {
        this.id=id;
        this.amount=ammount;
        this.date=date;

    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }
}
