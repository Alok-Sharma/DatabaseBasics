package com.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class lab7_dbhelper extends SQLiteOpenHelper {
	
	public static final String TAG=lab7_dbhelper.class.getSimpleName();
	public static final String DB_NAME="lab7.db";
	public static final int DB_VERSION=1;
	public static final String TABLE="lab7_table";
	public static final String LAB_ID=BaseColumns._ID;
	public static final String COLUMN1="Name";
	public static final String COLUMN2="Number";
	public static final String COLUMN3="College";
	
	Context context;
	
	public lab7_dbhelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table "+TABLE+"(_id INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN1+" TEXT, "+COLUMN2+" TEXT, "+COLUMN3+" TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("drop table if exists "+TABLE);
		this.onCreate(db);
	}

}
