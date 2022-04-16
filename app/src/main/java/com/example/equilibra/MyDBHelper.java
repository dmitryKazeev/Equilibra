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

    private Context context;
    private static final String DATABASE_NAME="BookExchange.db";
    private static final int DATABASE_VERSION= 1;
    private static final String TABLE_NAME="book_nearby";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_TITLE="book_title";
    private static final String COLUMN_AUTHOR="author_name";
    private static final String COLUMN_CONDITION="condition";
    private static final String COLUMN_EXCHANGE_FOR="exchange_for";

    public MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_TITLE + " TEXT, " +
                        COLUMN_AUTHOR + " TEXT, " +
                        COLUMN_CONDITION + "TEXT, " +
                        COLUMN_EXCHANGE_FOR + "TEXT0);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void AddBook(String title, String author, String condition, String exchangeFor){
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
