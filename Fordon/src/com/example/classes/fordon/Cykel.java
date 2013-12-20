package com.example.classes.fordon;

public class Cykel implements FordonInterface {
	@Override
	public void forward(){
		System.out.println("Cyklar framåt");
	}
	
	@Override
	public void stop(){
		System.out.println("Break!");
	}
	@Override
	public void changeGear(){
		System.out.println("Changeing gear");
	}
	@Override
	public void honk(){
		System.out.println("Pling pling");
	}

	@Override
	public void backward() {
		System.out.println("Cykel kan väll inte gå backåt");
		
	}

}
