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
	
	private JMenuItem newGame = new JMenuItem("Nytt Spel");
	private JMenuItem exit = new JMenuItem("Avsluta"); 
	private JMenuItem highscore = new JMenuItem("Top Lista");
	private JMenuItem about = new JMenuItem("Om");
	final JButton deleteAllHighscores = new JButton("Delete Highscore");
	private JTextArea highscoreList= new JTextArea();
	Gameplan game = new Gameplan();
	
	public BugFinder() {
		
		setTitle("BugFinder");
		menuBar.add(arkiv); menuBar.add(help);
		arkiv.add(newGame); arkiv.add(highscore); arkiv.add(exit);
		help.add(about);
		help.setMnemonic(KeyEvent.VK_H);arkiv.setMnemonic(KeyEvent.VK_A);
		newGame.setMnemonic(KeyEvent.VK_N);highscore.setMnemonic(KeyEvent.VK_S);exit.setMnemonic(KeyEvent.VK_V);
		highscore.addActionListener(this);exit.addActionListener(this);about.addActionListener(this);newGame.addActionListener(this);
		setJMenuBar(menuBar);

		add(game);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
//This code is if you select to create a new game
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGame){
			JOptionPane op = new JOptionPane("Vill du start ett spel?");
			op.setMessageType(JOptionPane.QUESTION_MESSAGE);
			op.setOptionType(JOptionPane.YES_NO_OPTION);
			JDialog d = op.createDialog(op,"Nytt Spel");
			d.setVisible(true);
			Object selectedValue = op.getValue();		
			Object noll = 0;

			if(selectedValue == noll){
				game.startGame();
			}   
		}
//This code is if you would like to read about the game
		if(e.getSource() == about){
			JOptionPane op = new JOptionPane("Detta spelet går ut på att fånga buggar genom\n" +
					"att trycka på dem med din mus\n" +
					"Spelet skapare heter: Mikael Johansson");
			
			JDialog d = op.createDialog(op, "About");
			d.setVisible(true);
		}
//This code is for you do exit the game
		if(e.getSource() == exit){
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
//This code is for viewing the top 10 scores
		if(e.getSource() == highscore){
			Databas db = new Databas();		
			try {
				db.database("highscores", 0);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			deleteAllHighscores.addActionListener(this);
			JDialog dia = new JDialog();
			dia.add(deleteAllHighscores, BorderLayout.SOUTH);
			highscoreList.setText(db.nameAndHighscore);
			dia.add(highscoreList, BorderLayout.NORTH);
			dia.setResizable(false);
			dia.setModal(false);
			dia.pack();
			dia.setVisible(true);
		}
		
		if(e.getSource() ==deleteAllHighscores){
			Databas db = new Databas();		
			try {
				db.database("Delete", 0);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String [] arg){
		BugFinder b = new BugFinder();
	}
}

//*******************************************här börjar spelet*************************************************
class Gameplan extends JPanel implements MouseListener, ActionListener{
	private Timer tim = new Timer(700, this); //this is to set the timer to view the bug for half a second and then hide it for half a second 
	private int points; //count how many times you press on the bug
	private int setLocationW; //set width location for bug
	private int setLocationH; //set height location for bug
	private int counter =0; //counts how many seconds the game have last
	private JButton bugImage = new JButton(new ImageIcon("Pokemon.png")); 
	
	public Gameplan() { //to initiate the game
		bugImage.addMouseListener(this); 
		bugImage.setSize(50,50);
		add(bugImage);
		setLayout(null);
		bugImage.setVisible(false);
		setPreferredSize(new Dimension(1000, 500));
	}
	//denna funktionen finns för att nollställa alla värden så att man kan starta nytt spel utan gamla värden
	private void resetGame(){
		points=0;
		counter = 0;
	}
	//kallar alltid nollställ() innan ett spel startar 
	public void startGame(){
		resetGame();
		tim.start();
	}
	//stoppar spelet
	public void stopGame(){
		tim.stop();
	}
	//än en gång så nollställer vi allt innan spelet startar, vill vara säker på att inga gamla värden sparas :)
	public void nyttSpel(){
		stopGame(); resetGame(); startGame();
	}
	//Timern, detta körs så ofta som timern är inställd på
	public void actionPerformed(ActionEvent e){
		Random r = new Random();//size of the screen in case you would like to change the window size
		setLocationW = r.nextInt(getWidth()-bugImage.getWidth());
		setLocationH = r.nextInt(getHeight()- bugImage.getHeight());
		
		
		if (bugImage.isVisible() == false) {//detta görs för att  buggen inte skall visas hella tiden, om vi inte har denna funktionen så 
											//kommer buggen vara synlig hella tiden fast på olika platser
			bugImage.setLocation(setLocationW, setLocationH);	
			bugImage.setVisible(true);
		}
		else if (bugImage.isVisible() == true) { 
			bugImage.setVisible(false);
		}
		if(counter == 75){//ungefär 1min om en loop är 700ms
			stopGame();
			JOptionPane gameOver = new JOptionPane("Du fick " + points);
			JDialog d = gameOver.createDialog(gameOver, "Game Over");
			d.setVisible(true);
			bugImage.setVisible(false);
			if (points > 0){//lägg till poäng i databasen om du får 
							//några, skulle kunna göra så att man bara lägger 
							//till ifall man kommer med på toplistan MEN om man 
							//ska bygga vidare på spelet för exempel nätvärksfunction 
							//så vill man kunna söka i highscore efter namn och få upp vilken placering de finns på
				Databas db = new Databas();	
				try {
					db.database("addHighscore", points);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		counter++;
	}

	@Override
	public void mouseClicked(MouseEvent bugImage) {
		points++; //räkna upp dina poäng
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
