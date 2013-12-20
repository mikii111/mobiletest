package com.example.main;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.*;

import java.awt.Image;
import java.io.File;


public class BugFinder extends JFrame implements ActionListener {
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu arkiv = new JMenu("Arkiv");
	private JMenu help = new JMenu("Hjälp");
	
	private JMenuItem nyttSpel = new JMenuItem("Nytt Spel");
	private JMenuItem avsluta = new JMenuItem("Avsluta"); 
	private JMenuItem topLista = new JMenuItem("Top Lista");
	private JMenuItem om = new JMenuItem("Om");
	Spelplan game = new Spelplan();//***************Behövs denna???
	
	public BugFinder() {
		
		setTitle("BugFinder");
		menuBar.add(arkiv); menuBar.add(help);
		arkiv.add(nyttSpel); arkiv.add(topLista); arkiv.add(avsluta);
		help.add(om);
		help.setMnemonic(KeyEvent.VK_H);arkiv.setMnemonic(KeyEvent.VK_A);
		nyttSpel.setMnemonic(KeyEvent.VK_N);topLista.setMnemonic(KeyEvent.VK_S);avsluta.setMnemonic(KeyEvent.VK_V);
		topLista.addActionListener(this);avsluta.addActionListener(this);om.addActionListener(this);nyttSpel.addActionListener(this);
		setJMenuBar(menuBar);
		Spelplan game = new Spelplan();
		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nyttSpel){
			JOptionPane op = new JOptionPane("Vill du start ett spel?");
			op.setMessageType(JOptionPane.QUESTION_MESSAGE);
			op.setOptionType(JOptionPane.YES_NO_OPTION);
			JDialog d = op.createDialog(op,"Nytt Spel");
			d.setVisible(true);
			Object selectedValue = op.getValue();		
			Object noll = 0;

			if(selectedValue == noll){
				//vad ska jag gör här om jag inte ska initiera spelplan?
				game.startaSpel();
			}   
		}
		if(e.getSource() == om){
			JOptionPane op = new JOptionPane("Detta spelet går ut på att fånga buggar genom\n" +
					"att trycka på dem med din mus\n" +
					"Spelet skapare heter: Mikael Johansson");
			
			JDialog d = op.createDialog(op, "About");
			d.setVisible(true);
		}
		if(e.getSource() == avsluta){
			JOptionPane op = new JOptionPane("Är du säker att du vill avsluta?");
			op.setMessageType(JOptionPane.QUESTION_MESSAGE);
			op.setOptionType(JOptionPane.YES_NO_OPTION);
			JDialog d = op.createDialog(op,"Avsluta");
			d.setVisible(true);
			Object selectedValue = op.getValue();		
			Object noll = 0;
			if(selectedValue == noll){
				System.exit(0);
			}   
		}
		if(e.getSource() == topLista){
			Databas db = new Databas();		
			try {
				db.databas("toplista");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane op = new JOptionPane(db.nameAndHighscore);
			JDialog d = op.createDialog(op, "Highscore");
			d.setVisible(true);
		
		}
	}

	public static void main(String [] arg){
		BugFinder b = new BugFinder();
	}
}

//*******************************************här börjar spelet*************************************************
class Spelplan extends JPanel implements MouseListener, ActionListener{
	private Timer tim = new Timer(1000, this);
	private int poäng;
	int setLocationW;
	int setLocationH;
	int points;
	
	private JButton bugImage = new JButton(new ImageIcon("bug.jpg"));
	
	public Spelplan() {
		bugImage.addMouseListener(this);
		add(bugImage);
		setPreferredSize(new Dimension(1000, 500));
		//jag får inte rätt storlek på fönstert nu?????
	}
	
	private void nollställ(){
		poäng=0;
		setLocationW = 0;
		setLocationH=0;
	}
	public void startaSpel(){
		tim.start();
		System.out.println("den går hit");
	}
	public void stoppaSpel(){
		tim.stop();
	}
	public void nyttSpel(){
		stoppaSpel(); nollställ(); startaSpel();
	}
	public void actionPerformed(ActionEvent e){
		Random r = new Random();
		setLocationW = r.nextInt(900);
		setLocationH = r.nextInt(400);
		
//här får jag felmeddelande på false?
		System.out.println(bugImage.isVisible());
		if (!bugImage.isVisible()) {
			bugImage.setLocation(setLocationW, setLocationH);
			bugImage.add(bugImage);
			bugImage.setVisible(true);
		}
		else { 
		    	bugImage.setVisible(false);
		}
		bugImage.repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent bugImage) {
		//check if you click on the jpanel bugPanel
		//if you hit the bugPanel it should be visible(false)
		//poäng++;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
