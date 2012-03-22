package com.db;

import java.util.ArrayList;
import java.util.List;

import com.lab7.R;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Lab_dbActivity extends ListActivity {
	List<String> namelist=new ArrayList<String>();
    List<String> numlist=new ArrayList<String>();
    List<String> collglist=new ArrayList<String>();
	lab7_dbhelper dbhelper;
	SQLiteDatabase db;
	int i=0;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);
        
        dbhelper=new lab7_dbhelper(this);
        db=dbhelper.getReadableDatabase();
        
        ContentValues values=new ContentValues();
        
        Bundle extras=getIntent().getExtras();
        if(extras.getInt("view")==0){			//Adding  things to the database if values were given in the
        										//calling activity
        	String mname=extras.getString("name");
        	String mnum=extras.getString("number");
        	String mcollg=extras.getString("collg");
        	values.put(dbhelper.COLUMN1, mname);
            values.put(dbhelper.COLUMN2, mnum);
            values.put(dbhelper.COLUMN3, mcollg);
            db.insert(dbhelper.TABLE, null, values);
        }
        
        //Populate lists with database values.
        Cursor c=db.query(dbhelper.TABLE, new String[]{dbhelper.COLUMN1,dbhelper.COLUMN2,dbhelper.COLUMN3}, null, null, null, null, null);
        if(c.moveToFirst()){
        	do{
        		namelist.add(c.getString(c.getColumnIndex(dbhelper.COLUMN1)));
        		numlist.add(c.getString(c.getColumnIndex(dbhelper.COLUMN2)));
        		collglist.add(c.getString(c.getColumnIndex(dbhelper.COLUMN3)));
        	}while(c.moveToNext());
        }
        
        //Putting all entries in the 3 lists onto the listview(using getModel)
        ArrayAdapter<db_model> myadapter= new db_arrayadapter(this,getModel(1), getModel(2),getModel(3));
        setListAdapter(myadapter);
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		db.close();
		dbhelper.close();
	}
	private List<db_model> getModel(int i){
		if(i==1){
			List<db_model> list1=new ArrayList<db_model>();
			for(int j=0;j<namelist.size();j++){
				list1.add(get(namelist.get(j),numlist.get(j),collglist.get(j),1));
			}
			return list1;
		}
		else if(i==2){
			List<db_model> list2=new ArrayList<db_model>();
			for(int j=0;j<numlist.size();j++){
				list2.add(get(namelist.get(j),numlist.get(j),collglist.get(j),2));
			}
			return list2;
		}
		else{
			List<db_model> list3=new ArrayList<db_model>();
			for(int j=0;j<collglist.size();j++){
				list3.add(get(namelist.get(j),numlist.get(j),collglist.get(j),3));
			}
			return list3;
		}
	}
	
	private db_model get(String namem,String numsm,String collgm, int k){
		if(k==1){
			return new db_model(namem,numsm,collgm,1);
		}
		else if(k==2){
			return new db_model(namem,numsm,collgm,2);
		}
		else
			return new db_model(namem,numsm,collgm,3);
	}
	
}