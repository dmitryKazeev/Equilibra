package com.example.equilibra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class book extends AppCompatActivity implements View.OnClickListener{
    Button nearby;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        nearby=(Button) findViewById(R.id.nearby);
        nearby.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.nearby) {
            Intent intent = new Intent(this, Nearby.class);
            startActivity(intent);
        }


    }


}