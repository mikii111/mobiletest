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
		System.out.println("Vad vill du göra? 1. för lägg till hund 2. för att skriva ut vilka hundar du har 3. för exit");
		answer = scanner.nextInt();
		while(answer != 3){
			
			if(answer == 1){
				if (i >= 3){
			        throw new IndexOutOfBoundsException();			
			    }
				System.out.println("mata in en hund börja med Namn");
				name = scanner.next();
				System.out.println("mata in ras på hunden. 1 för jackrussel, 2 för schäfer");
				race = scanner.nextInt();
				System.out.println("mata in ålder");
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
			System.out.println("Vad vill du göra? 1. för lägg till hund 2. för att skriva ut vilka hundar du har 3. för exit");
			answer = scanner.nextInt();
		}
	}
}
