package com.book.entities;

public class BookType {

	long bookId;
	String booknm;
	String bookauther;
	String bookdesc;
	double bookprice;
	
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookType(long bookId, String booknm, String bookauther, String bokkdesc, long bookprice) {
		super();
		this.bookId = bookId;
		this.booknm = booknm;
		this.bookauther = bookauther;
		this.bookdesc = bokkdesc;
		this.bookprice = bookprice;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBooknm() {
		return booknm;
	}

	public void setBooknm(String booknm) {
		this.booknm = booknm;
	}

	public String getBookauther() {
		return bookauther;
	}

	public void setBookauther(String bookauther) {
		this.bookauther = bookauther;
	}

	public String getBookdesc() {
		return bookdesc;
	}

	public void setBookdesc(String bookdesc) {
		this.bookdesc = bookdesc;
	}

	public double getBookprice() {
		return bookprice;
	}

	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	
	
	
}
