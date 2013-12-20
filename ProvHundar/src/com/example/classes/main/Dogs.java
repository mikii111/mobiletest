package com.example.classes.main;

public abstract class Dogs {
	private int age;
	private String name;

	public abstract String bark();
	

	public String getName(){
		return name;
	}
	public void setName(String emName){
		name=emName;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int dogsAge){
		age = dogsAge;
	}
}
