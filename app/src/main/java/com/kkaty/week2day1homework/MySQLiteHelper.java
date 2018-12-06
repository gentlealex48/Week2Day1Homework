package com.kkaty.week2day1homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import static com.kkaty.week2day1homework.Constants.DATABASE_VERSION;
import static com.kkaty.week2day1homework.Constants.DATABSE_NAME;
import static com.kkaty.week2day1homework.Constants.PASSWORD;
import static com.kkaty.week2day1homework.Constants.TABLE_NAME;
import static com.kkaty.week2day1homework.Constants.USER_NAME;
import static com.kkaty.week2day1homework.Constants.USER_NAME_KEY;

public class MySQLiteHelper  extends SQLiteOpenHelper {
    public MySQLiteHelper(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABSE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "("
                + USER_NAME + " TEXT PRIMARY KEY, "
                + PASSWORD + " TEXT)";
        Log.d("TAG", "onCreate: " + createTableQuery);
        db.execSQL(createTableQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean insertContact(String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_NAME, name);
        contentValues.put(PASSWORD, password);
        boolean ret = true;
        try {
            db.insert(TABLE_NAME, null, contentValues);
        } catch (SQLiteConstraintException s) {
            Log.d("SQL ERROR", "insertContact: " + s.getMessage());
            ret = false;
        }
        return ret;
    }
    public Cursor getUsersByName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + USER_NAME_KEY + " = \"" + name + "\"";
        Log.d("TAG", "getUsersByName: " + sql);
        Cursor res = db.rawQuery(sql, null);
        return res;
    }

}

