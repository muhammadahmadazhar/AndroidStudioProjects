package com.example.application127;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQL extends SQLiteOpenHelper {
    SQLiteDatabase db;

    //database name
    private static final String DATABASE_NAME="Student_info";
    //version always need to change whenever new changes apply to database
    private static final int DATABASE_VERSION=1;
    //database table
    private static final String TABLE_STUDENT="Student";
    //Table Student columns
    private static final String KEY_ROWID="_id";
    private static final String KEY_FIRST_NAME="firstname";
    private static final String KEY_LAST_NAME="lastname";
    public SQL(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENT_TABLE="CREATE TABLE " +TABLE_STUDENT+ "(" +KEY_ROWID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_FIRST_NAME+ " TEXT, " +KEY_LAST_NAME+ " TEXT);";
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_STUDENT);
        onCreate(db);
    }

    public long insertStudent(String strfirstname, String strlastname) {
        db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_FIRST_NAME,strfirstname);
        cv.put(KEY_LAST_NAME,strlastname);

        return db.insert(TABLE_STUDENT,null,cv);
    }

    public String getData() {
        db=this.getReadableDatabase();
        String[] columns=new String[]{KEY_ROWID,KEY_FIRST_NAME,KEY_LAST_NAME};
        Cursor c=db.query(TABLE_STUDENT,columns,null,null,null,null,null);

        String result="";
        int iRow=c.getColumnIndex(KEY_ROWID);
        int iFirstname=c.getColumnIndex(KEY_FIRST_NAME);
        int iLastname=c.getColumnIndex(KEY_LAST_NAME);
        for(c.moveToFirst(); !c.isAfterLast();c.moveToNext()){
            result = result + c.getString(iRow) + " " + c.getString(iFirstname) + " " + c.getString(iLastname) + "\n";
        }
        Log.d("deb", result);
        return result;
    }
}
