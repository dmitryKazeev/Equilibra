package com.example.equilibra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBook extends AppCompatActivity {

    EditText bookNameTxt, authorNameTxt, conditionTxt, exchangeForTxt;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        bookNameTxt = findViewById(R.id.bookNameTxt);
        authorNameTxt = findViewById(R.id.authorNameTxt);
        conditionTxt = findViewById(R.id.conditionTxt);
        exchangeForTxt = findViewById(R.id.exchangeForTxt);
        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDBHelper myDB = new MyDBHelper(AddBook.this);
                myDB.AddBook(bookNameTxt.getText().toString().trim(),
                        authorNameTxt.getText().toString().trim(),
                        conditionTxt.getText().toString().trim(),
                        exchangeForTxt.getText().toString().trim()
                        );
            }
        });

    }



}