package com.book;

import java.sql.ResultSet;
import java.util.Scanner;

import com.book.dao.BookSalerDBOperation;
import com.book.dao.CustomerDBOperation;
import com.book.entities.BookType;
import com.book.entities.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	System.out.println("===========================================================================================================================");
    	System.out.println("                                             Welcome to UNIQUE BOOK HOUSE                                                  ");
    	System.out.println("===========================================================================================================================");
    	
    	boolean status=true;
    	do
    	{
       try
       {
    	Scanner scan=new Scanner(System.in);
    	System.out.println("\t Press 1 -> Book Saler ");
    	System.out.println("\t Press 2 -> Customer ");
    	int userType=scan.nextInt();
    	
    	BookSalerDBOperation ob= new BookSalerDBOperation();
    	
    	if(userType==1)
    	{
    		System.out.println("\t Enter Saler Id:");
    		long sId=scan.nextLong();
    		System.out.println("\t Enter Password:");
    		String password=scan.next();
    		boolean validUser=ob.login(sId, password);
    		
    		if(validUser)
    		{
    	       	System.out.println("==========================================================================================================");
    			System.out.println("Login Successfull!!");
    	       	System.out.println("==========================================================================================================");
    	       	System.out.println("1.Customer registration\r\n"
    	       			+ "2.Check CustomerInfo\r\n"
    	       			+ "3.Change Password\r\n"
    	       			+ "4.Add book\r\n"
    	       			+ "5.Check bookInfo\r\n"
    	       			+ "6.Remove book\r\n"
    	       			+ "7.Remove Customer\r\n"
    	       			+ "8.Logout");
    	       	int operation=scan.nextInt();
    	       	if(operation==1)
    	       	{
    	       	System.out.println("Enter Id for the Customer:");	
    	       	long custId=scan.nextLong();
    	       	System.out.println("Enter Customer name:");
    	       	String custName=scan.next();
    	       	System.out.println("Enter Customer address:");
    	       	String custAddress=scan.next();
    	    	System.out.println("Enter Customer password:");
    	       	String custPassword=scan.next();
       	       	System.out.println("Enter Phone Number:");
    	        Long custNumber=scan.nextLong();
    	       	System.out.println("Enter email address:");
    	       	String custEmail=scan.next();
    	       	
    	       	Customer c =new Customer(custId,custName,custAddress,custPassword,custNumber,custEmail);
    	       	
    	       	if(ob.customerRegistration(c))
    	       	{
    	        	   System.out.println("==========================================================================================================");
	    	       	   System.out.println("Regiestration Succesfull!!");
	    	           System.out.println("==========================================================================================================");

    	       	}
    	       	else
    	       	{
    	       		System.out.println("Problem in Regiestration");
    	       	}
    	       	}  	       	
    	       	else if(operation==2)
    	   	   	{
    	       	   System.out.println("==========================================================================================================");
	        	   System.out.println("Customer Information");
	        	   System.out.println("==========================================================================================================");
	        	   System.out.println("Enter the Customer Id:");
	        	   long CustId=scan.nextLong();
	        	   ResultSet result=ob.checkCustomerinfo(CustId);
	        	   if(result!=null)
	        	   {
	        		 while(result.next()) 
	        		 {  
	        		   System.out.println("Customer Name:"+result.getString(2));
	        		   System.out.println("Address:"+result.getString(4));
	        		   System.out.println("Phone Number:"+result.getLong(5));
	        		   System.out.println("Email:"+result.getString(6));
	        		 }
	        	   }
    	    	}
    	       	else if(operation==3)
    	   	   	{
    	       		System.out.println("Enter  Customer Id:");
    	       		long sid=scan.nextLong();
    	       		System.out.println("Set new Password:");
    	       		String newPassword=scan.next();
    	       		if(ob.changePassword(sid, newPassword))
    	       		{
    	       			System.out.println("Password Changed!!");
    	       		}
    	       		else
    	       		{
    	       			System.out.println("Error occurred!!");
    	       		}	
    	    	}
    	       	else if(operation==4)
    	   	   	{
    	       		{
    	    	       	System.out.println("Enter Book Id:");	
    	    	       	long bookId=scan.nextLong();
    	    	       	System.out.println("Enter Book name:");
    	    	       	String booknm=scan.next();
    	    	       	System.out.println("Enter Book auther:");
    	    	       	String bookauther=scan.next();
    	    	    	System.out.println("Enter Book description:");
    	    	       	String bookdesc=scan.next();
    	       	       	System.out.println("Enter Book price:");
    	    	        long bookprice=scan.nextLong();
    	    	       	
    	    	       	BookType bt =new BookType(bookId,booknm,bookauther,bookdesc,bookprice);
    	    	       	
    	    	       	if(ob.addBook(bt))
    	    	       	{
    	    	        	   System.out.println("==========================================================================================================");
    		    	       	   System.out.println("Book added Succesfully !!");
    		    	           System.out.println("==========================================================================================================");

    	    	       	}
    	    	       	else
    	    	       	{
    	    	       		System.out.println("Book Not added !!");
    	    	       	}
    	       		} 
    	    	}
    	       	else if(operation==5)
    	   	   	{

     	       	   System.out.println("==========================================================================================================");
 	        	   System.out.println("Book Information");
 	        	   System.out.println("==========================================================================================================");
 	        	   System.out.println("Enter the Book Id:");
 	        	   long BookId=scan.nextLong();
 	        	   ResultSet result=ob.checkBookinfo(BookId);
 	        	   if(result!=null)
 	        	   {
 	        		 while(result.next()) 
 	        		 {  
 	        		   System.out.println("Book Name:"+result.getString(2));
 	        		   System.out.println("Book auther:"+result.getString(3));
 	        		   System.out.println("Book Description:"+result.getString(4));
 	        		   System.out.println("Book Price:"+result.getLong(5));
 	        		 }
 	        	   }	
    	    	}
    	       	else if(operation==6)
    	   	   	{
    	       		System.out.println("Enter Book id:");
    	       		long BookId=scan.nextLong();
    	       		
    	       		if(ob.removeBook(BookId))
    	       		{
    	       			System.out.println("Book deleted successfully!! ");
    	       		}
    	       		else
    	       		{
    	       			System.out.println("Problem in book deleting!! ");
    	       		}		    	        			
    	    	}
    	       	else if(operation==7)
    	   	   	{
    	       		System.out.println("Enter Customer id to remove customer:");
    	       		long CustId=scan.nextLong();
    	       		
    	       		if(ob.removeCustomer(CustId))
    	       		{
    	       			System.out.println("Customer deleted successfully!! ");
    	       		}
    	       		else
    	       		{
    	       			System.out.println("Problem in customer deleting!! ");
    	       		}	
    	    	}
    	       	else if(operation==8)
    	   	   	{

    	       		ob.logout();
    	       		System.out.println("==========================================================================================================");
        			System.out.println("Logged Out!! ");
        	       	System.out.println("==========================================================================================================");

    	    	}
    		}
    		else
    		{
    	       	System.out.println("==========================================================================================================");
    			System.out.println("Incorrect UserId/PAssword!! ");
    	       	System.out.println("==========================================================================================================");

    		}
     	}
    	
//*****************************************************************************************************************************************************************//    	
    	else if(userType==2)
    	{
    		CustomerDBOperation ob1= new CustomerDBOperation();
    		
    		System.out.println("\t Enter Customer Id:");
    		long custId=scan.nextLong();
    		System.out.println("\t Enter Password:");
    		String custpassword=scan.next();
    		boolean validUser=ob1.login(custId,custpassword);
    		
    		if(validUser)
    		{
    	       	System.out.println("==========================================================================================================");
    			System.out.println("Login Successfull!!");
    	       	System.out.println("==========================================================================================================");
    	       	System.out.println("1.Check profile\r\n"
    	       		//	+ "2.Show Books\r\n"
    	       			+ "2.Change Password\r\n"
    	       			+ "3.Check bookInfo \r\n"
    	       			+ "4.Show Sale Details\r\n"
    	       			+ "5.Logout");
    	       	int operation=scan.nextInt();
    	       	
    	       	if(operation==1)
    	       	{
    	       	   System.out.println("==========================================================================================================");
 	        	   System.out.println("      Your Profile      ");
 	        	   System.out.println("==========================================================================================================");
 	        	   System.out.println("Please Enter your Id:");
 	        	   long CustId=scan.nextLong();
 	        	   ResultSet result=ob1.checkProfile(CustId);
 	        	   if(result!=null)
 	        	   {
 	        		 while(result.next()) 
 	        		 {  
 	        		   System.out.println("Customer Name:"+result.getString(2));
 	        		   System.out.println("Address:"+result.getString(4));
 	        		   System.out.println("Phone Number:"+result.getLong(5));
 	        		   System.out.println("Email:"+result.getString(6));
 	        		 }
 	        	   }
    	       		
    	       	}
    	       	else if(operation==2)
    	       	{
    	       	 		System.out.println("Enter new password:");
    		    		String newPassword=scan.next();
    		       		if(ob1.changePassword(custId, newPassword))
    		       		{
    		       			System.out.println("==========================================================================================================");
    		    			System.out.println("Password changed successfully!!");
    		    	       	System.out.println("==========================================================================================================");

    		       		}
    		       		else
    		       		{
    		       			System.out.println("==========================================================================================================");
    		    			System.out.println("Problem in password change!!");
    		    	       	System.out.println("==========================================================================================================");

    		       		}
    		   	}
    	     	else if(operation==3)
    	   	   	{
    	       	   System.out.println("==========================================================================================================");
	        	   System.out.println("Book Information");
	        	   System.out.println("==========================================================================================================");
	        	   System.out.println("Enter Book Id:");
	        	   long bookId=scan.nextLong();
	        	   ResultSet result=ob1.checkBookinfo(bookId);
	        	   if(result!=null)
	        	   {
	        		 while(result.next()) 
	        		 {  
	        		   System.out.println("Book Name:"+result.getString(2));
	        		   System.out.println("Auther:"+result.getString(3));
	        		   System.out.println("Discription:"+result.getString(4));
	        		   System.out.println("Price:"+result.getDouble(5));
	        		 }
	        	   }
	        	   
	        	   ResultSet validUser1=ob1.checkBookinfo(bookId);
	       		
	       		if(validUser)
	       		{
	       	       	System.out.println("==========================================================================================================");
	       			System.out.println(" Buy Book Now !!");
	       	       	System.out.println("==========================================================================================================");
	       	       	System.out.println("1.Pay Amount Now\r\n"
	       	       			+ "2.Not intrested\r\n"
	       	       			);
	       	     
	       	       	int operations=scan.nextInt();
	       	    
	       	       	if(operations==1)
			     	{
			       	       //	System.out.println("Deposit book amount :");
				       		double n =scan.nextDouble();
					       	System.out.println("==========================================================================================================");	
				       		ob1.depositPrice(bookId, custId);
					       //	System.out.println("Congrats !!!!");
					       	System.out.println("==========================================================================================================");	

					       	
	       	       			
	       	       	}
	       	       	else if(operations==2)
	       	       	{
	       	       		System.out.println("Thank You !!");
	       	       	}
	       	       		
	      	     }
	       	   else
			     	{
			       		System.out.println("\t Please enter a correct input!!");
			       	}
	       		
    	    	}
    	   
    	     	else if(operation==4)
    	       	{
    	       		System.out.println("==========================================================================================================");
           			System.out.println("SaleDetId" + "\t" +"Customer Id" + "\t"  + "Book Id"  + "\t\t"   +"Price");
    	       		System.out.println("==========================================================================================================");

    	       		ResultSet rs=ob1.saledetaile(custId);
    	      // 		ResultSet rs = null;
					while(rs.next())
    	       		{
    	       			System.out.println(rs.getLong(1) + "\t\t" +rs.getLong(3)+ "\t\t"+rs.getLong(2)+"\t\t"+rs.getDouble(4));

    	       		}
    	       		System.out.println("==========================================================================================================");

    	       	}
    	     	
    	       	
    	       	else if(operation==5)
    	       	{
    	       		ob1.logout();
    	       		status=false;
    	       		System.out.println("==========================================================================================================");
        			System.out.println(				" THANK  YOU !!!!\r\n"
        											+"\t\t "+"Visit Again !!!!!!");
        	       	System.out.println("==========================================================================================================");

    	       	}
    	    	else 
    	       	{
    	    		System.out.println("==========================================================================================================");
        			System.out.println("Wrong Input!!");
        	       	System.out.println("==========================================================================================================");

    	       	}
    	       	
    	       	
    		}
    		else
    		{
    			System.out.println("==========================================================================================================");
    			System.out.println("User Id or Password Incorrect!!");
    	       	System.out.println("==========================================================================================================");

    		}
    	       	
    		}
    		
    	
        else
    	{
    		System.out.println("\t Please enter a correct input!!");
    	}
       }
       catch(Exception e)
       {
    	   System.out.println(e.getMessage());
    	   System.out.println("\t Wrong Input!!");
    	   System.out.println("\t Provide Number input!!");
       	   System.out.println("==========================================================================================================");
       	   
       	   
       }
    	}
    	while(status);
    }
    }

