package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  EditText e1,e2;

Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                String des=e2.getText().toString();
                DBHandler db=new DBHandler(MainActivity.this);
                db.insert(name,des);
                Toast.makeText(getApplicationContext(),"Inserted SuccessFully",Toast.LENGTH_LONG).show();
                Intent i=new Intent(MainActivity.this,Second.class);
              //startActivity(i);
            }
        });
    }
}
