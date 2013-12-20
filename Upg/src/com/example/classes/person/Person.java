package com.example.classes.person;

public class Person {
	//private int age;
	private String name;
	private int age;
	public Person(){
		this("Micke", 22);
	}

	public Person(String name, int age){
		setPerson(name, age);
	}
	void setPerson(String name, int age) {
		this.name = name;
		this.age = age;
		
	}

	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	
	
}
