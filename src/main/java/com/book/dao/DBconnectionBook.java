package com.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnectionBook {

Connection conn=null;
	
	public Connection connection()
	{
		
		String databaseUrl="jdbc:mysql://localhost:3306/BookAplication";
		String userName="root";
		String userPassword="mysql";
		
			
				try {
					conn=DriverManager.getConnection(databaseUrl, userName, userPassword);
					
				} 
				
				catch (SQLException e) {
					
					e.printStackTrace();
					//System.out.println("Internal Server Error!!");
				}
				if(conn!=null)
				{
					System.out.println("Connected SuccesFully");
				}
				
				return conn;
}
}
