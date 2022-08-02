package com.example.recyclerview_java;

import android.content.Context;
import android.content.Intent;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder>{


    Context context;
    private String[] data; //here we get data that we want to show in recycler view
    public MyAdapter(String[] data) // here we are passing string array
    {
        this.data=data;


    }

    // this method will get called as soon as object of this class is created  and this method will create holder and view
    // after that next method will get called onBindViewHolder() which bind view with data
    // here we have also created inner class which store reference of view inside list item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String txt=data[position];
        holder.textView.setText(txt);

        //this method is used to set onclick listener on each item in recyclerview


    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.cardtxtview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(view.getContext(),MainActivity2.class);  //in this way we can go on next activity from onclick method
                    intent.putExtra("text",data[getAdapterPosition()]);
                    view.getContext().startActivity(intent);
                }
            });


        }



    }
}
