package com.example.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

//Det ända jag inte kan tänka funkar är att den ska skriva ut allt 
//samtidigt som man skriver in text och ta bort om man tar bort, nu funkar allt bara om man trycker enter
public class Gui extends JFrame implements ActionListener{
	JLabel TextOut;
	JTextField TextIn;
	String text = "";
	
	public Gui(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		TextIn = new JTextField(200);
		TextOut = new JLabel(text);
		panel.add(TextIn);
		panel.add(TextOut);
		
		add(panel, BorderLayout.CENTER);
		setTitle("Röverspråket");
		setSize(1000,85);
		TextIn.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		Scanner sc = new Scanner(TextIn.getText());
		String s = sc.nextLine();
		String konsonanter1 = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNOPQRSTVWXZ";	//Spara alla konsonanter i en string
		char konsonanter[] = konsonanter1.toCharArray();	//Gör om sträng till char array
		
		String mening = s.toString();
		int tecken = mening.length();
		mening.toLowerCase();
		char rovar[] = mening.toLowerCase().toCharArray();
		String rovarmening ="";
		
		for(int i = 0; i<tecken; i++){
			for(int x = 0; x<40; x++){
				if(rovar[i] == konsonanter[x]){
					String del = rovar[i]+"o"+rovar[i];
					rovarmening = rovarmening+del;
					TextOut.setText(rovarmening);
					break;
				}else if (x == 19){
					String del = rovar[i]+"";
					rovarmening = rovarmening+del;
					TextOut.setText(rovarmening);
					break;
				}
			}
		}
	}
}