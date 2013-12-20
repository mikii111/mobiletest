package com.example.main;

import javax.swing.JOptionPane; 


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Databas {
		Statement statement = null;	
		public String nameAndHighscore ="";
		private String sql;
		public void database(String viewOrDelete, int points)throws SQLException{
			Connection connection = null;
			String Username = "root";
			String Password = "229934";
			
			try{
				connection = DriverManager.getConnection("jdbc:mysql://localhost/guidb?user="+Username+"&password="+Password);
				statement = connection.createStatement();	
				if (viewOrDelete =="highscores")
					getHighscore();
				
				if(viewOrDelete =="Delete")
					deleteAllHighscores();
				
				if(viewOrDelete =="addHighscore")
					addHighscore(points);
			}
			catch(SQLException exception){
			    System.out.println("SQLException: " + exception.getMessage());
			    System.out.println("SQLState: " + exception.getSQLState());
			    System.out.println("VendorError: " + exception.getErrorCode());
			}
			finally{
				try{
					if(statement != null)
						statement.close();
					if(connection != null)
						connection.close();
				}
				catch(SQLException exception){
					throw exception;
				}
			}
		}
		
		private void addHighscore(int points) throws SQLException {
			int i = 0;
			int[] oldPoints = new int[10];
			boolean addHighscore = false;
			
			sql = "Select name, highscore from highscore " +
					"ORDER BY highscore DESC " +
					"limit 10;";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				oldPoints[i] = resultSet.getInt("highscore");
				i++;
				
			}
			for(int j = 0; j<oldPoints.length; j++){
				if (oldPoints[j]<points){
					addHighscore = true;
					j=100;
				}
			}
			sql = "Select count(highscore) AS total from highscore;";
			resultSet = statement.executeQuery(sql);
			resultSet.next();
			
			if (resultSet.getInt("total") < 10){
				addHighscore = true;
			}
			if(addHighscore == true){
				String name= JOptionPane.showInputDialog("Namn: ");
				
				sql = "INSERT INTO highscore(name, highscore) VALUES('"+
						name+"', '"+points+"');";
				if(name != null){
					try {
						statement.executeUpdate(sql);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		private void deleteAllHighscores() {
			sql = "Delete from highscore;";
			try {
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public void getHighscore() throws SQLException {
			sql = "Select name, highscore from highscore " +
					"ORDER BY highscore DESC " +
					"limit 10;";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				nameAndHighscore += resultSet.getString("name") +"       Highscore:     " +resultSet.getString("highscore") + "\n";
			}
		}


}
