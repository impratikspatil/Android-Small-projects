package com.example.recyclerview_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recview); // get reference of recyclerview

        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // here I have set layout manager for adapter i.e. how recyclerview will appear on screen either vertically
                                                                                //horizontally or something else

        String [] textlist={"pratik","suraj","prajyot","prasad","jatin","ybhav","shreyash","pratik","suraj","prajyot","prasad","jatin","ybhav","shreyash"}; // this is list of string array that we are passing as parameter to MyAdapter class

        recyclerView.setAdapter(new MyAdapter(textlist)); // here we have set adapter to recyclerview

    }
}