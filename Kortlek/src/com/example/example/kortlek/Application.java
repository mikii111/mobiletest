package com.example.example.kortlek;

public class Application {
	public static void main(String[] args){
		DeckOfCards game = new DeckOfCards();
		String a =  game.GenDeck().toString();
		System.out.print(a.toString());
	}
}
