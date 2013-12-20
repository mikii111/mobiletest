package com.example.classes.stack;

import java.util.Scanner;

public class Application {
	public static void main(String[] args){
		int amountInStack = 0;
		int val;
		String contin;
		Object item = null;
		Scanner scanner = new Scanner(System.in);
		do{
			
			System.out.println("Hur m�nga element ska stacken inneh�lla?");
			amountInStack = scanner.nextInt();
			Stack stack = new Stack(amountInStack); 
			do{
				System.out.println("Vill du l�gga till(1), ta bort(2) eller se om stacken �r tom(3) ?");
				val = scanner.nextInt();
				if(val == 1){
					System.out.println("Skriv in vad du vill l�gga till i stacken");
					item = scanner.next();
					stack.push(item);
				}
				if(val == 2){
					stack.pop();
				}
				if(val == 3){
					stack.isEmpty();
				}
			}
			while(val != 1 || val != 2 || val != 3);
			
			System.out.println("Vill du forts�tta?");
			contin = scanner.next();
			contin.toUpperCase();
		}while(contin == "Y" );
		scanner.close();
	}
}
