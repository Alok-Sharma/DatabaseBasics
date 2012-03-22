package com.db;

import java.util.List;

import com.lab7.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class db_arrayadapter extends ArrayAdapter<db_model> {
	private final Activity context;
	private final List<db_model> names;
	private final List<db_model> nums;
	private final List<db_model> collg;
	
	public db_arrayadapter(Activity context,List<db_model> names, List<db_model> nums, List<db_model> collg){
		super(context,R.layout.db_rowlayout,names);
		this.context=context;
		this.names=names;
		this.nums=nums;
		this.collg=collg;
	}
	
	static class ViewHolder{
		public TextView nametv;
		public TextView numtv;
		public TextView collgtv;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		ViewHolder holder;
		View rowView=convertView;
		if(rowView==null){
			LayoutInflater inflater=context.getLayoutInflater();
			rowView=inflater.inflate(R.layout.db_rowlayout, null,true);
			holder=new ViewHolder();
			holder.nametv=(TextView)rowView.findViewById(R.id.rowname);
			holder.numtv=(TextView)rowView.findViewById(R.id.rownum);
			holder.collgtv=(TextView)rowView.findViewById(R.id.rowcollg);
			rowView.setTag(holder);
		}else{
			holder=(ViewHolder)rowView.getTag();
		}
		holder.nametv.setText(names.get(position).getName());
		holder.numtv.setText(nums.get(position).getNumber());
		holder.collgtv.setText(collg.get(position).getCollg());
		return rowView;
	}
}
