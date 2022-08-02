package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Objects;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //For hiding actionbar
        Objects.requireNonNull(getSupportActionBar()).hide();

        //for hiding status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //here we have created thread for this process i.e. to show splash screen activity
        Thread t=new Thread(){
            public void run()
            {
                try{
                    sleep(3000);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {

                    finish();

                }
            }
        };t.start();
    }
}