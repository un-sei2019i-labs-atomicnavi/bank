package first.program.bank1.data_Acces.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "User")
public class User  {

    @DatabaseField(allowGeneratedIdInsert = true)
    private int cedula;//primary key
    @DatabaseField(index = true, canBeNull = false)
    private String name;
    @DatabaseField
    private int password;
    @DatabaseField
    private int account;
    public User(String name,int cedula,int password,int acont) {

        this.name=name;
        this.cedula=cedula;
        this.password=password;
        this.account=acont;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
