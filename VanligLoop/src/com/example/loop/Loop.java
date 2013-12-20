package com.example.loop;

public class Loop {
	public static void main(String [] args){
		long startTime = System.currentTimeMillis();
		long endTime = 0;
		long talet=990900000;
		long sum = 0;
		long q = talet;
		for(int i = 0; i < q; i++){
			sum += talet*talet*talet;
			talet--;
		}

		System.out.println(sum);
		
		endTime = System.currentTimeMillis();
		long timeneeded =  ((startTime - endTime) /1000);
		System.out.println(timeneeded);
	}
}
