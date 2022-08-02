package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Objects;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

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
                    //intent to move from this activity to another activity
                    Intent i=new Intent(MainActivity3.this,MainActivity4.class);
                    startActivity(i);
                    finish();

                }
            }
        };t.start();    }
}