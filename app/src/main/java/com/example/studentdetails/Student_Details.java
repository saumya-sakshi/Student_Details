package com.example.studentdetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Student_Details extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DetailStudent> list=new ArrayList<>();
    private AdapterStudent Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__details);
        recyclerView=findViewById(R.id.recycler);
        DetailStudent d1 = new DetailStudent("Saumya","451","112","CSE","9973874503","saumyasakshi41@gmail.com",R.drawable.a1);
        list.add(d1);
        DetailStudent d2 = new DetailStudent("Sakshi","227","180","CSIT","9787471881","saumyasakshi41@gmail.com",R.drawable.a2);
        list.add(d2);
        DetailStudent d3 = new DetailStudent("Meenakshi","274","109","CSE","7787984002","saumyasakshi41@gmail.com",R.drawable.a3);
        list.add(d3);
        DetailStudent d4 = new DetailStudent("Neha","452","22","EEE","6203353450","saumyasakshi41@gmail.com",R.drawable.a4);
        list.add(d4);
        DetailStudent d5 = new DetailStudent("Nisha","303","73","CSE","7991101303","saumyasakshi41@gmail.com",R.drawable.a5);
        list.add(d5);
        DetailStudent d6 = new DetailStudent("ANURADHA","10","39","ETC","9525955538","saumyasakshi41@gmail.com",R.drawable.a6);
        list.add(d6);


        Adapter = new AdapterStudent(Student_Details.this,list);
        Adapter.setHasStableIds(false);
        recyclerView.setAdapter(Adapter);
        recyclerView.setHasFixedSize(false);
        //                          mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        //                          mRVFishPrice.setLayoutManager(new GridLayoutManager(MainActivity.this,1));
        recyclerView.setLayoutManager(new LinearLayoutManager(Student_Details.this,LinearLayoutManager.VERTICAL,true));
 }
    public class DetailStudent{
        public String name;
        public String rollno;
        public String id;
        public String clas;
        public String phone;
        public String email;
        public int photo;

        public DetailStudent(String name, String rollno, String id, String clas, String phone,String email, int photo) {
            this.name = name;
            this.rollno = rollno;
            this.id = id;
            this.clas = clas;
            this.phone = phone;
            this.email=email;
            this.photo = photo;
        }
    }
    public class AdapterStudent extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        List<DetailStudent> data= Collections.emptyList();
        int currentPos = 0;
        private Context context;
        private LayoutInflater inflater;
        // create constructor to initialize context and data sent from MainActivity
        public AdapterStudent(Context context, List<DetailStudent> data) {
            this.context = context;
            inflater = LayoutInflater.from(context);
            this.data = data;
        }
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.template, parent, false);
            final AdapterStudent.MyHolder holder = new AdapterStudent.MyHolder(view);
            return holder;

        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            // Get current position of item in recyclerview to bind data and assign values from list
            final AdapterStudent.MyHolder myHolder = (AdapterStudent.MyHolder) holder;


            myHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(context, data.get(position).id, Toast.LENGTH_SHORT).show();
                }
            });

            final DetailStudent current = data.get(position);




            myHolder.call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse("tel:"+current.phone);
                    Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(intent);
                }
            });
//            myHolder.mailbtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    String subject="Hello";
//                    Intent intent = new Intent(Intent.ACTION_SEND);
//                    intent.setType("*/*");
//                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ current.email});
//                    intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//                    intent.setType("message/rfc822");
//                    if (intent.resolveActivity(getPackageManager()) != null) {
//                        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
//                    }
//                }
//            });



          Toast.makeText(context, list.get(position).rollno, Toast.LENGTH_SHORT).show();
            myHolder.name.setText(current.name);
            myHolder.rollno.setText(current.rollno);
//            myHolder.id.setText(current.id);
            myHolder.clas.setText(current.clas);
            myHolder.phone.setText(current.phone);
            myHolder.imag.setImageResource(current.photo);
            myHolder.Email.setText(current.email);
            //          myHolder.plus.setVisibility(View.GONE);
//            myHolder.minus.setVisibility(View.GONE);
            //        myHolder.delete.setVisibility(View.GONE);



        }

        @Override
        public int getItemCount() {
            return data.size();
        }
        class MyHolder extends RecyclerView.ViewHolder {
            TextView name;
            TextView rollno;
            TextView id;
            TextView clas;
            TextView phone;
            Button call;
            Button mailbtn;
            ImageView imag;
            ImageButton minus;
            ImageButton delete;
            TextView Email;

            // create constructor to get widget reference
            public MyHolder(View itemView) {
                super(itemView);
                name = (TextView)itemView.findViewById(R.id.name);
                rollno = (TextView)itemView.findViewById(R.id.rollno);
                //id = (TextView)itemView.findViewById(R.id.cost);
                clas = (TextView)itemView.findViewById(R.id.clas);
                phone = (TextView)itemView.findViewById(R.id.phone);
                mailbtn=(Button)findViewById(R.id.mailbtn);
                call = (Button)itemView.findViewById(R.id.call);
                imag =(ImageView)itemView.findViewById(R.id.imag);
                Email =(TextView)itemView.findViewById(R.id.email);
                //              plus = (Button)itemView.findViewById(R.id.plus);
//                minus = (ImageButton)itemView.findViewById(R.id.minus);
//                delete = (ImageButton)itemView.findViewById(R.id.del);

                //  id= (TextView)itemView.findViewById(R.id.id);
            }


        }



    }
}