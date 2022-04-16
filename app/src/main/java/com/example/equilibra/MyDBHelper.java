package com.example.equilibra;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    public Context context;
    public static final String DATABASE_NAME="BookExchange.db";
    public static final int DATABASE_VERSION= 1;
    public static final String TABLE_NAME="book_nearby";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_TITLE="book_title";
    public static final String COLUMN_AUTHOR="author_name";
    public static final String COLUMN_CONDITION="condition";
    public static final String COLUMN_EXCHANGE_FOR="exchange_for";

    public MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + "( " + COLUMN_ID + " integer primary key," + COLUMN_TITLE + " text," +
                COLUMN_CONDITION + " text," + COLUMN_AUTHOR +" text," + COLUMN_EXCHANGE_FOR +" text" + ");" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void AddBookNearby(String title, String author, String condition, String exchangeFor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_CONDITION, condition);
        cv.put(COLUMN_EXCHANGE_FOR, exchangeFor);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show();
        }



    }
}
