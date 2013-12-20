package com.example.databas;
import java.sql.*;


public class Databas {
	public String employee = "There was no emploeey with this name :(";
	public void databas(String sql,String quary, String whatToDo)throws SQLException{
		Connection connection = null;
		Statement statement = null;	
		//System.out.println(sql);
		
		String Username = "root";
		String Password = "229934";
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost/exampledatabase?user="+Username+"&password="+Password);
			statement = connection.createStatement();
			
			
			
			//menningen är att genom ett GUI kunna göra alla saker enkelt, alltså ska man kunna: updatera table, 
			//kolla vad som finns i en table, lägga till, ta bort
			
			if (whatToDo == "update"){
				
			}
			System.out.println(sql+" '"+quary+"'");
			if (whatToDo =="view"){
				ResultSet resultSet = statement.executeQuery(sql+" '"+quary+"'");
				
				while(resultSet.next()){
					employee=resultSet.getString("firstname")+" "+ resultSet.getString("lastname")+" "+resultSet.getString("employeeNumber");
					//gui.setTextinInfo(employee);
					System.out.println(resultSet.getString("firstname")+" "+ resultSet.getString("lastname")+" "+resultSet.getString("employeeNumber"));
				}
			}
			
			if (whatToDo == "add"){
				statement.execute(sql);
			}
			if (whatToDo == "delete"){
				ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE firstName like "+"'"+quary+"'");
				boolean i = false;
				while(resultSet.next()){
					i = true;
				}
				if(i == false){
					employee = quary+" Could not be found";
				//	gui.setTextinInfo(employee);
				}else{
					statement.executeUpdate(sql+" '"+quary+"'");
					employee = quary+" was deleted";
					//gui.setTextinInfo(employee);
				}
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
}
