package com.example.abstractclasses.employed;

public abstract class Employ {
	private int ID;
	private double salary;
	private String name;

	
	public abstract double tax();
	

	public String getName(){
		return name;
	}
	public void setName(String emName){
		name=emName;
	}
	public int getID(){
		return ID;
	}
	public void setID(int IDnr){
		ID = IDnr;
	}
	public void setSalary(double emSalary){
		 salary = emSalary;
		}
	public double getSalary(){
		 return salary;
	}
	public String ToString(){
		  return "Anställningsnr: " + getID() +" namn:" + getName() +" Salary: "+ getSalary() +" Tax: "+ tax();
	}
}
