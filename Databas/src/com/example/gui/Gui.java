package com.example.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.example.databas.Databas;

@SuppressWarnings("serial")
public class Gui extends JFrame implements ActionListener{
	private JRadioButton Update= new JRadioButton("Update Customer", false);
	private JRadioButton Delete = new JRadioButton("Delete Customer", false);
	private JRadioButton Add= new JRadioButton("Add Customer", false);
	private JRadioButton View= new JRadioButton("View Customer", false);
	JTextField Output = new JTextField();
	private JTextField Search= new JTextField();
	JTextField info = new JTextField();
	private JLabel SearchLabel = new JLabel("Search input:");
	private JButton Run = new JButton("RUN");
	private String sql = null;
	public String quary;
	Databas db = new Databas();
	ButtonGroup g = new ButtonGroup();
	public Gui(){
		setLayout(new FlowLayout());

		add(Update, BorderLayout.NORTH); add(Delete, BorderLayout.NORTH); add(Add, BorderLayout.NORTH);add(View, BorderLayout.NORTH);
		g.add(Update); g.add(Delete); g.add(Add); g.add(View);
		
		add(SearchLabel);
		add(Search);
		Search.setPreferredSize(new Dimension(500, 25));
		
		add(Output);
		Output.setEditable(false);
		Output.setPreferredSize(new Dimension(500, 400));
		
		add(info);
		info.setEditable(false);
		info.setPreferredSize(new Dimension(500, 25));

		add(Run);
		Run.addActionListener(this);
		
		setTitle("Database Updater");
		setSize(580,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//Lyssnare
	public void actionPerformed (ActionEvent e){
		if(Update.isSelected()){
			
		}
		if(Add.isSelected()){
			
		}
		if(Delete.isSelected()){
			Scanner sc = new Scanner(Search.getText());
			quary = sc.next();
			sql = "DELETE FROM employees WHERE firstname like ";
			String whatToDo = "delete";
			try {
				db.databas(sql, quary, whatToDo);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(View.isSelected()){
			Scanner sc = new Scanner(Search.getText());
			quary = sc.next();
			sql = "SELECT * FROM employees WHERE firstName like ";
			String whatToDo = "view";
			try {
				db.databas(sql, quary, whatToDo);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
	}
	public String setTextinInfo(String text){
		info.setText(text);
		return null;
	}
}
