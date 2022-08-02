package com.example.recyclerview_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //for hiding status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //here we have created thread for this process i.e. to show splash screen activity
        Thread t=new Thread(){
            public void run()
            {
                try{
                    sleep(3500);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    //intent to move from this activity to another activity
                    Intent i=new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();

                }
            }
        };t.start();

    }
}