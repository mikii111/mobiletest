package com.example.classes.person;

public class Person {
	private int age;
	private String name;
	
	public Person(){
		this("kalle", 15);		
	}
	public Person(String name, int age){
		setAge(age);
		setName(name);
	} 
	
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}