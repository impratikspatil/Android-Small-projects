package com.example.volleyapiuse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    public  static final String URL ="https://api.github.com/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final RecyclerView recyclerView= findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //stringrequest  is created and successlisterner and errorlister is added
        StringRequest request=new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("success",response);
                GsonBuilder gsonBuilder= new GsonBuilder();
                Gson gson=gsonBuilder.create();
                User[] users=gson.fromJson(response,User[].class);
                recyclerView.setAdapter(new GithubAdapter(MainActivity.this, users));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"somwthing went wrong",Toast.LENGTH_SHORT).show();

            }
        });


        // string request is added in requestqueue
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(request);

    }
}