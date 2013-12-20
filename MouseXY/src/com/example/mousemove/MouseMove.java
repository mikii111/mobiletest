package com.example.mousemove;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

public class MouseMove extends JFrame {
	int X;
	int Y;
	JLabel label;
	JPanel child; 
	MouseMove(){
		getContentPane().addMouseMotionListener(l);
		  
		/*setSize(400, 400);
		setLocation(200,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);*/
	}
	private JPanel getContent()  
    {  
        label = new JLabel();  
        label.setHorizontalAlignment(JLabel.CENTER);  
        GridBagLayout gridbag = new GridBagLayout();  
        GridBagConstraints gbc = new GridBagConstraints();  
        child = new JPanel(gridbag);  
        child.setBorder(BorderFactory.createEtchedBorder());  
        child.setPreferredSize(new Dimension(400,400));  
        child.add(label, gbc);  
        JPanel parent = new JPanel(gridbag);  
        parent.setOpaque(true);  
        parent.add(child, gbc);  
        return parent;  
    }  
	MouseMotionListener l = new MouseAdapter(){
		@Override	
		public void mouseMoved(MouseEvent e){
			String s ="";
			X = e.getX();
			Y= e.getY();
			System.out.println(X + " "+ Y);
			if(X > 0 && Y > 0)  
				s = "X = " + X + "  Y = " + Y;  
			label.setText(s);  
		}
	};
	
	public static void main(String arg[]){
		MouseMove mouse = new MouseMove();      
		JPanel panel = mouse.getContent();  
        JFrame f = new JFrame();  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setContentPane(panel);  
        f.setSize(500,500);  
        f.setLocation(200,200);  
        f.setVisible(true);  
	}
	

	
}
