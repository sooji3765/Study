package com.example.user.memoproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public DBhelper(Context context) {
        super(context, "memodb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String memoSql = "create table tb_memo"
                +"(_id integer primary key autoincrement,"
                +"title,"
                +"content)";
        db.execSQL(memoSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (newVersion == DATABASE_VERSION){
            db.execSQL("drop table tb_memo");
            onCreate(db);
        }
    }


}
