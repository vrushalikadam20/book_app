package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class CustomerDBOperation {
	DBconnectionBook ob=new DBconnectionBook();
	Connection conn=ob.connection();
	
	public boolean login(long custId,String custpassword) throws SQLException //login
	{
		
		PreparedStatement stmt=conn.prepareStatement("select * from Customer where custId=? and custpassword=? ");

	    stmt.setLong(1, custId);
		stmt.setString(2,custpassword);
		
		ResultSet result=stmt.executeQuery();
		if(result.next())
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	public ResultSet checkProfile (long custId) throws SQLException
	{
		ResultSet result=null;
		try
		{
			PreparedStatement stmt=conn.prepareStatement("select * from customer where custId=? ");

			stmt.setLong(1, custId);
	
			result=stmt.executeQuery();
		}
		catch(Exception e)
		{
			System.out.println("Wrong Customer Id..!!");
		}
		return result;
	
	}




	synchronized public boolean changePassword(long custId,String newPassword) throws SQLException //change password
	{
		PreparedStatement stmt=conn.prepareStatement("update customer set CustPassword=? where custId=? ");
		stmt.setString(1,newPassword);
		stmt.setLong(2, custId);
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	

	public ResultSet checkBookinfo (long BookId) throws SQLException
	{
		ResultSet result=null;
		try
		{
		PreparedStatement stmt=conn.prepareStatement("select * from booktype where BookId=? ");

		stmt.setLong(1, BookId);
	
		result=stmt.executeQuery();
		}
		catch(Exception e)
		{
			System.out.println("Wrong Book Id..!!");
		}
		return result;
	
	}
	
	public ResultSet depositPrice( long bookId ,long custId) 
	{
		try
		{
			PreparedStatement stmt=conn.prepareStatement("select * from booktype where bookId=? ");
			
			stmt.setLong(1,bookId);
			ResultSet result=stmt.executeQuery();
			double bookPrice=0.0;
			while(result.next())
			{
				bookPrice=result.getDouble(5);
			}
			
			//bookPrice=bookPrice+bookAmount;
			Random r=new Random();
			long SaleDetId=r.nextLong(99999);//10000
			
			Scanner scan=new Scanner(System.in);
			double n;
			System.out.println("To buy enter the book amount:");
			n=scan.nextDouble();
			  	if(bookPrice==n)
				{
			  		stmt=conn.prepareStatement("insert into saledetaile values(?,?,?,?)");
					
					stmt.setLong(1,SaleDetId);
		    	 	stmt.setLong(2, custId);
					stmt.setLong(3, bookId);
					stmt.setDouble(4 ,bookPrice);
					//stmt.executeQuery();
			    	System.out.println("Book order successfull !!!");
				}
				else
				{
					System.out.println("Please enter sufficiet amount*****");
				}			
		}
		catch(Exception e)
			{
				e.printStackTrace();
			}
		return null;
	}

	synchronized public ResultSet saledetaile(long custId)
 	{
 		ResultSet rs=null;
 		try
 		{
 		PreparedStatement pr=conn.prepareStatement("select * from saledetaile where custId=?");
 		pr.setLong(1, custId);
 		rs=pr.executeQuery();
 		
 		}
 		catch(Exception e)
 		{
 			e.printStackTrace();
 			//System.out.println("Somethinng went wrong!!");
 		}
 		return rs;
 	}


	public void logout() throws SQLException
	{
		conn.close();
	}

	
	
}