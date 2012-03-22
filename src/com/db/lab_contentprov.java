package com.db;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class lab_contentprov extends ListActivity {
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Cursor mcursor=getContacts();
		startManagingCursor(mcursor);
		
		ListAdapter adapter=new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,
				mcursor,new String[]{ContactsContract.Contacts.DISPLAY_NAME},new int[]{android.R.id.text1});
		setListAdapter(adapter);
	}
	
	private Cursor getContacts(){
		Uri uri=ContactsContract.Contacts.CONTENT_URI;
		String[] projection=new String[] {ContactsContract.Contacts._ID,
				ContactsContract.Contacts.DISPLAY_NAME};
		String selection=ContactsContract.Contacts.IN_VISIBLE_GROUP+" = '"+("1")+"'";
		String[] selectionArgs=null;
		String sortOrder=ContactsContract.Contacts.DISPLAY_NAME+" COLLATE LOCALIZED ASC";
		
		return managedQuery(uri,projection,selection,selectionArgs,sortOrder);
		}
	}

