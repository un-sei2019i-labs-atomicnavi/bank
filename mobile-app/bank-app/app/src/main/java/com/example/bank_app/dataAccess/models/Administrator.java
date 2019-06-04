package com.example.bank_app.dataAccess.models;

public class Administrator {
    String name;
    int cedula;
    String password;
    public Administrator(String name,int cedula,String password){
        this.name=name;
        this.cedula=cedula;
        this.password=password;

    }
}
