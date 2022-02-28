package com.book.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.entities.BookType;
import com.book.entities.Customer;


public class BookSalerDBOperation {

	DBconnectionBook ob=new DBconnectionBook();
	Connection conn=ob.connection();
	
	synchronized public boolean login(long sid,String password) throws SQLException
	{
		
		PreparedStatement stmt=conn.prepareStatement("select * from booksaler where salerId=? and salerPassword=? ");

	    stmt.setLong(1, sid);
		stmt.setString(2,password);
		
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
	
	public boolean customerRegistration(Customer e) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("Insert into customer values(?,?,?,?,?,?) ");
		stmt.setLong(1, e.getCustId());
		stmt.setString(2,e.getCustName());
		stmt.setString(3,e.getCustAddress());
		stmt.setString(4,e.getCustPassword());
		stmt.setLong(5,e.getPhone());
		stmt.setString(6, e.getCustEmail());
		
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
	public ResultSet checkCustomerinfo (long CustId) throws SQLException
	{
		ResultSet result=null;
		try
		{
		PreparedStatement stmt=conn.prepareStatement("select * from customer where custId=? ");

		stmt.setLong(1, CustId);
	
		result=stmt.executeQuery();
		}
		catch(Exception e)
		{
			System.out.println("Wrong Customer Id..!!");
		}
		return result;
	
	}

	public boolean changePassword(long sid,String newPassword) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("update customer set custPassword=? where CustId=? ");
		stmt.setString(1,newPassword);
		stmt.setLong(2, sid);
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
	public boolean addBook(BookType e) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("Insert into booktype values(?,?,?,?,?) ");
		stmt.setLong(1, e.getBookId());
		stmt.setString(2,e.getBooknm());
		stmt.setString(3,e.getBookauther());
		stmt.setString(4,e.getBookdesc());
		stmt.setDouble(5,e.getBookprice());
				
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
	
	public boolean removeBook(long BookId) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("delete from booktype where BookId=? ");
		stmt.setLong(1, BookId);
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

	
	public boolean removeCustomer(long CustId) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("delete from Customer where CustID=? ");
		stmt.setLong(1, CustId);
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

	public void logout() throws SQLException
	{
		conn.close();
	}

	

	/*public ResultSet Saledetaile(long custId) {


		return null;
	}
*/


	
}
