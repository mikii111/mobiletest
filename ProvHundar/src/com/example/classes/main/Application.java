package com.example.classes.main;
import java.util.*;
public class Application {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int antalHundar = 3;
		Dogs[] dogs = new Dogs[antalHundar];
		int race;
		String name;
		int age;
		int answer;
		int i = 0;
		System.out.println("Vad vill du g�ra? 1. f�r l�gg till hund 2. f�r att skriva ut vilka hundar du har 3. f�r exit");
		answer = scanner.nextInt();
		while(answer != 3){
			
			if(answer == 1){
				if (i >= 3){
			        throw new IndexOutOfBoundsException();			
			    }
				System.out.println("mata in en hund b�rja med Namn");
				name = scanner.next();
				System.out.println("mata in ras p� hunden. 1 f�r jackrussel, 2 f�r sch�fer");
				race = scanner.nextInt();
				System.out.println("mata in �lder");
				age = scanner.nextInt();
				
					if (race == 1){
						JackRussel jackrussel = new JackRussel();
						jackrussel.setName(name);
						jackrussel.setAge(age);
						dogs[i] = jackrussel;
						i++;
					}
					if (race == 2){
						Schafer schafer = new Schafer();
						schafer.setName(name);
						schafer.setAge(age);
						dogs[i] = schafer;
						i++;
					}
			}
			if (answer == 2){
				for(int index = 0; index < i; index++){
					System.out.println("Name: " + dogs[index].getName() +" Age: "+dogs[index].getAge()  + " Bark: "+  dogs[index].bark()+ "\n");
				}
			}
			System.out.println("Vad vill du g�ra? 1. f�r l�gg till hund 2. f�r att skriva ut vilka hundar du har 3. f�r exit");
			answer = scanner.nextInt();
		}
	}
}
