package com.example.main;

import javax.swing.JFrame;

public class Game {
	public static void  main(String [] args){
		Gui gui = new Gui();
		gui.setTitle("Menu test");
		gui.setSize(1000,500);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
}
