package com.example.abstractclasses.employed;


public class Pensioner extends Employ {
	
	public double tax(){
		final double per = 0.3144;
		return getSalary() * per;

	}

}