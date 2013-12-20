package com.example.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Databas {
		Statement statement = null;	
		public String nameAndHighscore ="";
		private String sql;
		public void databas(String viewOrDelete)throws SQLException{
			Connection connection = null;
			String Username = "root";
			String Password = "229934";
			
			try{
				connection = DriverManager.getConnection("jdbc:mysql://localhost/guidb?user="+Username+"&password="+Password);
				statement = connection.createStatement();	
				if (viewOrDelete =="toplista"){
					getHighscore();
				}
				if(viewOrDelete =="Delete"){
					deleteAllHighscores();
				}
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
		
		private void deleteAllHighscores() {
			sql = "Delete * from highscore;";
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
