package com.tanvir.tanvirmahmudkhan.workingwithapi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabase extends SQLiteOpenHelper {

    private static final String dataBaseName = "TanvirDB";

    private static final int versionNumber = 1;


    private Context context;

    public MyDatabase(Context context) {
        super(context, dataBaseName, null, versionNumber);
        this.context = context;
    }

    public long insertLoginInfo(String UserId, String Password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("UserId", UserId);
        contentValues.put("Password", Password);

        long rowID = sqLiteDatabase.insert("LoginInfo",null,contentValues);

        return rowID;
    }

    public boolean checkValidity(String UserId, String Password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from LoginInfo where UserId='"+UserId+"' AND Password ='"+Password+"';",null);

        if(cursor.getCount()!=0){
            //Toast.makeText(context,"Cursor: "+cursor.getCount()+"Username: "+uname,Toast.LENGTH_LONG).show();
            return true;
        }
        else{
            //Toast.makeText(context,"Cursor: "+cursor.getCount()+"Username: "+uname,Toast.LENGTH_LONG).show();
            return false;
        }

    }

    //Table Create SQL
    private static final String createTable_LoginInfo ="create table LoginInfo (UserId varchar(200) primary key, Password varchar(200));";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTable_LoginInfo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Toast.makeText(context,"On upgrade called",Toast.LENGTH_LONG).show();
    }
}
