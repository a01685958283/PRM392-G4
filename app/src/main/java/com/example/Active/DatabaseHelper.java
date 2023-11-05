package com.example.Active;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "Signup_pro.db";

    public DatabaseHelper(@Nullable Context context){

        super(context, "Signup_pro.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table users(phone TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String phone, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("phone", phone);
        contentValues.put("password", password);
        long result = MyDatabase.insert("users", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkPhone(String phone){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where phone = ?", new String[]{phone});
        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkPhonePassword(String phone, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();

        Cursor cursor = MyDatabase.rawQuery("Select * from users where phone = ? and password = ?", new String[]{phone, password});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

}
