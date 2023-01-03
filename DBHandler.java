package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHandler extends SQLiteOpenHelper {

    private final static String DB_NAME="EMP";
    private final static String TABLE_NAME="emp_detail";
    private final static String KEY_NAME="emp_name";
    private final static String KEY_DES="des";
     DBHandler(Context context)
  {
      super(context,DB_NAME,null,1);
  }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="create table "+TABLE_NAME+"("+KEY_NAME+" TEXT,"+KEY_DES+" TEXT)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
onCreate(db);
    }
    public void insert(String name,String  des)
    {
       SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_NAME,name);
        cv.put(KEY_DES,des);
        long newId=db.insert(TABLE_NAME,null,cv);
        db.close();
    }
    public ArrayList<HashMap<String,String>> getDetail()
    {
        ArrayList<HashMap<String,String>> users=new ArrayList<>();
        SQLiteDatabase db=getWritableDatabase();
        String Query="Select * from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(Query,null);
        HashMap<String,String> user=new HashMap<>();

        while(cursor.moveToNext())
        {
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("des",cursor.getString(cursor.getColumnIndex(KEY_DES)));
        }
        users.add(user);
        return users;
    }
}
