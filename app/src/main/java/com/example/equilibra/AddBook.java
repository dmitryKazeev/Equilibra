package com.example.equilibra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddBook extends AppCompatActivity implements View.OnClickListener{

    EditText bookNameTxt, authorNameTxt, conditionTxt, exchangeForTxt;
    Button addBtn;

    MyDBHelper dbHelper;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener((View.OnClickListener) this);


        bookNameTxt =(EditText) findViewById(R.id.bookNameTxt);
        authorNameTxt =(EditText) findViewById(R.id.authorNameTxt);
        conditionTxt =(EditText) findViewById(R.id.conditionTxt);
        exchangeForTxt =(EditText) findViewById(R.id.exchangeForTxt);
        dbHelper = new MyDBHelper(this);

    }
    @Override
    public void onClick(View view) {
        String bookName = bookNameTxt.getText().toString();
        String authorName = authorNameTxt.getText().toString();
        String condition = conditionTxt.getText().toString();
        String exchangeFor = exchangeForTxt.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        switch (view.getId()){

            case R.id.addBtn:
                contentValues.put(dbHelper.COLUMN_TITLE , bookName);
                contentValues.put(dbHelper.COLUMN_AUTHOR , authorName);
                contentValues.put(dbHelper.COLUMN_CONDITION , condition);
                contentValues.put(dbHelper.COLUMN_EXCHANGE_FOR , exchangeFor);

                database.insert(dbHelper.TABLE_NAME , null , contentValues);


                break;
        }
    }

}