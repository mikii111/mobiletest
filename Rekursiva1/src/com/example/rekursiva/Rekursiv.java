package com.example.rekursiva;

public class Rekursiv {
	public static void main(String [] args) {
		float talet = 10000;
		long startTime = System.currentTimeMillis();
		long endTime = 0;
		float i=fakultet(talet);
		System.out.println("fakulteten på: "+talet+" blir: "+i);
		endTime = System.currentTimeMillis();
		long timeneeded =  ((startTime - endTime) /1000);
		System.out.println(timeneeded);
	}
	public static float fakultet(float talet) {
		
		if (talet<=1){
			return 1;
		}
		else{
			return talet*talet*talet+fakultet(talet-1);
		}
	}
}
