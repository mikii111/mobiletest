package com.example.meny;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class FrameMeny extends JFrame {
		JMenuBar menuBar = new JMenuBar();
		JMenu Arkiv = new JMenu("Arkiv");
		JMenu Help = new JMenu("Hj�lp");
		JMenuItem Avsluta = new JMenuItem("Avsluta");
		JMenuItem Open = new JMenuItem("�ppna");
		JMenuItem About = new JMenuItem("Om Bildvisaren");
		
		JFileChooser fc = new JFileChooser();
		JLabel bild = new JLabel();
		private String aktuellFil = "namnl�s";
	FrameMeny(){
		menuBar.add(Arkiv);menuBar.add(Help);
		
		Arkiv.add(Open);Arkiv.add(Avsluta);
		Help.add(About);
		
		setJMenuBar(menuBar);
		Help.setMnemonic(KeyEvent.VK_H);
		Arkiv.setMnemonic(KeyEvent.VK_A);
		
		

		//Avsluta.showMessageDialog();
		Avsluta.addActionListener(avslutaProgram);
		Open.addActionListener(�ppnaBild);
		add(bild);
		Help.addActionListener(helpme);
		
		
		setTitle("Menu test");
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	Action �ppnaBild = new AbstractAction("�ppna"){
		public void actionPerformed(ActionEvent e){
			if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
				l�InFil(fc.getSelectedFile().getAbsolutePath());
			}
		}
	};
	Action avslutaProgram = new AbstractAction("Avsluta"){
		public void actionPerformed(ActionEvent e){
			JOptionPane op = new JOptionPane("�r du s�ker att du vill avsluta?");
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
	private void l�InFil(String filnamn) {
		try{
			FileReader r = new FileReader(filnamn);
			r.close();
			aktuellFil = filnamn;
			setTitle(aktuellFil);
			ImageIcon icon = new ImageIcon(aktuellFil); 
			bild.setIcon(icon);
			
		}
		catch(IOException e){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "det gick ej");
		}
	}
	Action helpme = new AbstractAction("Help"){
		public void actionPerformed(ActionEvent e){
			int i = 0;
		}
	};
}
