package com.example.main;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.*;



public class Gui extends JFrame{


	JMenuBar menuBar = new JMenuBar();
	JMenu arkiv = new JMenu("Arkiv");
	JMenu help = new JMenu("Hjälp");
	JMenuItem nyttSpel = new JMenuItem("Nytt Spel");
	JMenuItem avsluta = new JMenuItem("Avsluta"); 
	JMenuItem topLista = new JMenuItem("Top Lista");
	JMenuItem om = new JMenuItem("Om");
	JPanel mainPanel = new JPanel();

	int setLocationW = 0;
	int setLocationH = 0;
	int score = 0;
	ImageLabel bug = new ImageLabel(new ImageIcon("C:/Users/miki/Desktop/mobiletest/GUIprojekt/src/bug.jpg"));
	  
	public Gui(){
		menuBar.add(arkiv); menuBar.add(help);
		
		arkiv.add(nyttSpel); arkiv.add(topLista); arkiv.add(avsluta);
		help.add(om);
		
		mainPanel.setSize(1000, 500);
		
		help.setMnemonic(KeyEvent.VK_H);
		arkiv.setMnemonic(KeyEvent.VK_A);
		nyttSpel.setMnemonic(KeyEvent.VK_N);
		topLista.setMnemonic(KeyEvent.VK_S);
		avsluta.setMnemonic(KeyEvent.VK_V);
		setJMenuBar(menuBar);
		
		topLista.addActionListener(highscore);
		avsluta.addActionListener(avslutaProgram);
		om.addActionListener(om1);
		nyttSpel.addActionListener(nyttSpel1);
		add(mainPanel);
		bug.addActionListener(countScore);
		
	}
	
	Action avslutaProgram = new AbstractAction("avsluta"){
		public void actionPerformed(ActionEvent e){
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
	};	
	
	Action countScore = new AbstractAction("countScore"){
		public void actionPerformed(ActionEvent e){
			score +=1;
			System.out.println(score);
		}
	};	
	

	Action highscore = new AbstractAction("topLista"){
		public void actionPerformed(ActionEvent e){
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
	};	
	
	
	Action om1 = new AbstractAction("om"){
		public void actionPerformed(ActionEvent e){
			JOptionPane op = new JOptionPane("Detta spelet går ut på att fånga buggar genom\n" +
					"att trycka på dem med din mus\n" +
					"Spelet skapare heter: Mikael Johansson");
			
			JDialog d = op.createDialog(op, "About");
			d.setVisible(true);
		}
	};	
	
	Action nyttSpel1 = new AbstractAction("nyttSpel"){
		public void actionPerformed(ActionEvent e){
			JOptionPane op = new JOptionPane("Vill du start ett spel?");
			op.setMessageType(JOptionPane.QUESTION_MESSAGE);
			op.setOptionType(JOptionPane.YES_NO_OPTION);
			JDialog d = op.createDialog(op,"Nytt Spel");
			d.setVisible(true);
			Object selectedValue = op.getValue();		
			Object noll = 0;
			//toolkit = Toolkit.getDefaultToolkit();

			if(selectedValue == noll){
				 for(int tim = 0; tim <= 6; tim++){		
					 Timer addBug = new Timer();
//						mainPanel.add(bug);
//						bug.setLocation(setLocationW, setLocationH);
//						
//						mainPanel.revalidate();
//						mainPanel.repaint();
						/*timer = new Timer();
						timer.schedule(new removeBug(), 1 * 1000);
						timer1 = new Timer();
						timer1.schedule(new addBug(), 1 * 2000);*/
			     }
				
			}   
		}
	};
	
	class ImageLabel extends JLabel {

		  public ImageLabel(String img) {
		    this(new ImageIcon(img));
		  }



		public void addActionListener(Action countScore) {
			// TODO Auto-generated method stub
			score+=1;
			System.out.println(score);
		}



		public ImageLabel(ImageIcon icon) {
		    setIcon(icon);
		    setIconTextGap(0);
		    setBorder(null);
		    setText(null);
		    setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
		  }
	
	}
}
