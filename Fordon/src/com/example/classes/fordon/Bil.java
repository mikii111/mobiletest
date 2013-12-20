package com.example.classes.fordon;


public class Bil implements FordonInterface {
	@Override
	public void forward(){
		System.out.println("We are rolling");
	}
	@Override
	public void backward(){
		System.out.println("Going back");
	}
	@Override
	public void stop(){
		System.out.println("Stop");
	}
	@Override
	public void changeGear(){
		System.out.println("Changeing gear");
	}
	@Override
	public void honk(){
		System.out.println("Honk honk");
	}
}
