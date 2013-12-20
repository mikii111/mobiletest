
package com.example.abstractclasses.employed;
import java.util.*;
 
public class Application {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Employ[] employ = new Employ[3];
		
		
		int IDnumber;
		String name;
		int b=1;
		double salary;
		int empleyNr;
		
		for (int i = 0; i < 3 ; i++){
			System.out.println("Mata in anställd nr " + b + " börja med Namn");
			name = scanner.next();
			System.out.println("och nu skriv in lön");
			salary = scanner.nextDouble();
			System.out.println("och nu skriv in id");
			IDnumber = scanner.nextInt();
			System.out.println("och nu skriv in anställning");
			System.out.println("anställning måste vara 1 för Normal, 2 för Pensionär eller 3 för Ungdom");
			empleyNr = scanner.nextInt();
				
			
				if (empleyNr == 1){
					Normal normal = new Normal();
					normal.setName(name);
					normal.setSalary(salary);
					normal.setID(IDnumber);
					employ[i] = normal;
				}
				if (empleyNr == 2){
					Pensioner pensioner = new Pensioner();
					pensioner.setName(name);
					pensioner.setSalary(salary);
					pensioner.setID(IDnumber);
					employ[i] = pensioner;
				}
				if (empleyNr == 3){
					Ungdom ungdom = new Ungdom();
					ungdom.setName(name);
					ungdom.setSalary(salary);
					ungdom.setID(IDnumber);
					employ[i] = ungdom;
				}
				b++;
				 
		}
		
		 for(Employ empl:employ){
		       System.out.printf(empl.ToString());
		 } 
		scanner.close();
	}
}