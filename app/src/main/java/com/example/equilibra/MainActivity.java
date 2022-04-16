package com.example.equilibra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView iv1, btnAddEx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1=(ImageView) findViewById(R.id.iv1);
        iv1.setOnClickListener(this);

        btnAddEx=(ImageView) findViewById(R.id.btnAddEx);
        btnAddEx.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv1) {
            Intent intent = new Intent(this, book.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.btnAddEx) {
            Intent intent = new Intent(this, AddBook.class);
            startActivity(intent);
        }


    }
}