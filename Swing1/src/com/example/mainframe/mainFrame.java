package com.example.mainframe;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import com.example.main.ImageIcon;

public class mainFrame extends JFrame{
	public mainFrame(){
		setTitle("Mickes application");
		setSize(300, 450);
		getContentPane().setBackground(Color.green);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		 mainFrame.addWindowListener(new WindowListener() {

		        @Override
		        public void windowClosing(WindowEvent e) {
		            if (JOptionPane.showConfirmDialog(mainFrame, "Are you sure you want to quit?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {
		                return;
		            }
		            System.exit(-1);
		        }

		        @Override 
		        public void windowOpened(WindowEvent e) {}

		        @Override 
		        public void windowClosed(WindowEvent e) {}

		        @Override 
		        public void windowIconified(WindowEvent e) {}

		        @Override 
		        public void windowDeiconified(WindowEvent e) {}

		        @Override 
		        public void windowActivated(WindowEvent e) {}

		        @Override 
		        public void windowDeactivated(WindowEvent e) {}

		    });
	}
}
