package com.example.animationimage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Mdplayer extends AppCompatActivity {

    MediaPlayer md;
    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdplayer);
        md=MediaPlayer.create(this,R.raw.toffan);
    }

    public void play(View view){
        md.start();
    }

    public void pause(View view)
    {
        md.pause();

    }

    public void stop(View view)
    {

        md.stop();
        md=MediaPlayer.create(this,R.raw.nucleya);



    }
}