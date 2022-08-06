package com.example.animationimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view)
    {
        ImageView img1=findViewById(R.id.img1);
        ImageView img2=findViewById(R.id.img2);
        ImageView img3=findViewById(R.id.img3);
        ImageView img4=findViewById(R.id.img4);


        img2.animate().alpha(1).setDuration(4000);


        Intent intent=new Intent(MainActivity.this,Mdplayer.class);
        startActivity(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}