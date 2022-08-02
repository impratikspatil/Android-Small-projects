package com.example.recyclerview_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView t= findViewById(R.id.main2txtview);
        String s = getIntent().getStringExtra("text");
        // this is the way to take value send by intent to given activity
        t.setText(s);

    }
}