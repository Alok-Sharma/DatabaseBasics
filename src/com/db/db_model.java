package com.db;

public class db_model {
	private String name;
	private String nums;
	private String collg;
	
	public db_model(String name,String nums, String collg, int k){
		if(k==1){
			this.name=name;
		}
		else if(k==2){
			this.nums=nums;
		}
		else
			this.collg=collg;
	}
	
	public String getName(){
		return name;
	}
	public String getNumber(){
		return nums;
	}
	public String getCollg(){
		return collg;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setNumber(String num){
		this.nums=num;
	}
}
