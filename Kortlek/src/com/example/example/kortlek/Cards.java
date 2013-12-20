package com.example.example.kortlek;

public class Cards {
	public enum Number{
		two, three, four, five, six, seven, aight, nine, ten, jack, queen, king, ace
	}
	public enum Color{
		hearts, diamonds, spades, clubs
	}
	private final Number numberValue;
	private final Color colorValue;

	Cards(Number numberValue, Color colorValue){
		this.numberValue = numberValue;
		this.colorValue = colorValue;
	}
	public Color color(){
		return colorValue;
	}
	public Number number(){
		return numberValue;
	}
	@Override
	public String toString(){
		return this.numberValue + " " + this.colorValue; 
	}
	
}
