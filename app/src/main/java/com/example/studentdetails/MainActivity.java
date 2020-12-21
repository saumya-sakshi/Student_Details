package com.example.studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name;
EditText password;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= findViewById(R.id.name);
        password=findViewById(R.id.pass);
        btn = findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.e("name",name.getText().toString());
                //Log.e("password",password.getText().toString());
                if(name.getText().toString().equals("Admin") ){
                  //  Log.e("enter","if works");
                    Intent intent = new Intent(MainActivity.this,Page2.class);
                    startActivity(intent);
                }
                else{
                    //Log.e("else","gone to else part");
                    Toast.makeText(MainActivity.this,"Enter correct details",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}