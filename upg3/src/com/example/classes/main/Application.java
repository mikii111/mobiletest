package com.example.classes.main;
import java.util.Scanner;
import java.lang.String;

public class Application {
	@SuppressWarnings("resource")
	public static void main(String[] args ){
		Scanner talin = new Scanner(System.in);
		String i, conti = "N";
		double a, b;
		do{
		System.out.println("Skriv in ett tal");
		a = talin.nextDouble();
		System.out.println("* + - / ???");
		i = talin.next();
		System.out.println("Skriv in nästa tal");
		b = talin.nextDouble();
		double sum=Switchare.switchare(a, b, i);
		Printer.printerSum(sum);
			do{
				System.out.println("\n Vill du fortsätta? Y/N");
				conti = talin.next().toUpperCase();
			}while(!conti.equals("N") && !conti.equals("Y"));
		}while(conti.equals("Y"));
	}
}

class Printer {
	public static void printerSum(double a){
		System.out.printf("%.2f",a);
	}
	
}
class Switchare {
	public static double switchare(double a, double b, String i){
		double sum = 0;
		switch(i){
		case "*":
			sum=Modifierare.multi(a, b);
			break;
		case "+":
			sum=Modifierare.plus(a,b);
			break;
		case "-":
			sum=Modifierare.min(a, b);
			break;
		case "/":
			sum=Modifierare.div(a, b);
			break;
		}
		return sum;
	}
}