package com.example.bank_app.dataAccess.models;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class User {
    String name;
    int cedula;
    int password;
    int account;

    public User(Context context) {

    }
}
