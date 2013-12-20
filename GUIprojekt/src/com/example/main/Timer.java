package com.example.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Timer extends Gui implements ActionListener{
	private Timer tim = new Timer(1000, this);
	//private Timer tim1 = new Timer(1000, l);
	public Timer(int i, Timer timer){
		
	}
	public void start(){
		tim.start();
	}
	public void stop(){
		tim.stop();
	}
	public void actionPerformed(ActionEvent e){
		Random r = new Random();
		setLocationW = r.nextInt(900);
		setLocationH = r.nextInt(400);
		bug.setLocation(setLocationW, setLocationH);
		mainPanel.add(bug);
		bug.revalidate();
    	bug.repaint();
    	mainPanel.revalidate();
    	mainPanel.repaint();
	    System.out.println("repaint1");
	}
	public void actionPerformed1(ActionEvent l){
		Random r = new Random();
		setLocationW = r.nextInt(900);
		setLocationH = r.nextInt(400);
		bug.setLocation(setLocationW, setLocationH);
		mainPanel.add(bug);
		bug.revalidate();
    	bug.repaint();
    	mainPanel.revalidate();
    	mainPanel.repaint();
	    System.out.println("repaint1");
	}
}
