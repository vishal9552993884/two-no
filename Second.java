package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        DBHandler db=new DBHandler(this);
        ArrayList<HashMap<String,String>> list=db.getDetail();
        TextView t=(TextView) findViewById(R.id.t1);
        t.setText(list.indexOf(1));
    }
}
