package com.example.example.kortlek;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards{
	private List<Cards> newDeck;
	
	public List<Cards> GenDeck(){
		newDeck = new ArrayList<Cards>();
		
		for (Cards.Color color : Cards.Color.values()){
			for (Cards.Number number : Cards.Number.values()){
				newDeck.add( new Cards(number, color));
			}
		}
		return newDeck;
	}
	
}