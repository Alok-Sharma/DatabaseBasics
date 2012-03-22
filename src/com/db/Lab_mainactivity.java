package com.db;

import com.lab7.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Lab_mainactivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final EditText name=(EditText)findViewById(R.id.editText1);
        final EditText num=(EditText)findViewById(R.id.editText2);
        final EditText collg=(EditText)findViewById(R.id.editText3);
        final Button submit=(Button)findViewById(R.id.button1);
        final Button view=(Button)findViewById(R.id.button2);
        final Button phone=(Button)findViewById(R.id.button3);
        final Intent i=new Intent(Lab_mainactivity.this, Lab_dbActivity.class);
        final Intent i2=new Intent(Lab_mainactivity.this,lab_contentprov.class);
    
        submit.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			String mname=name.getText().toString();
			String mnum=num.getText().toString();
			String mcollg=collg.getText().toString();
			i.putExtra("name", mname);
			i.putExtra("number", mnum);
			i.putExtra("collg",mcollg);
			i.putExtra("view", 0);
			name.setText("");
			num.setText("");
			collg.setText("");
			startActivity(i);
		}
    	
        });
        view.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				i.putExtra("view", 1);
				startActivity(i);
			}
        });
        phone.setOnClickListener(new OnClickListener(){

        	@Override
			public void onClick(View arg0) {
				startActivity(i2);
			}
        });
	}

}
