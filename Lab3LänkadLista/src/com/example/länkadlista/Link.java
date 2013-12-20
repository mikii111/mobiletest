package com.example.länkadlista;

class Link{
	public int iData; // data item (key)
	public double dData; // data item
	public Link next; // next link in list
	public Link previous;
	public Link(int id){
		iData = id;
	}

	public void displayLink(){
		System.out.print(iData + "<-->");
	}
} 