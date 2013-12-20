package com.example.classes.main;
import com.example.classes.person.*;

public class Application {
	public static void main(String [] args){
		Person newPerson = new Person();
		System.out.println(newPerson.getName() + " " +newPerson.getAge());
	}
}
