package com.example.hireskill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        HomeFragment homeFragment= new HomeFragment();
        ChatFragment chatFragment=new ChatFragment();
        UserSkillFragment userSkillFragment=new UserSkillFragment();


    }




}