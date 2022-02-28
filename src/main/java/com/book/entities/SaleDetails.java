package com.book.entities;

public class SaleDetails {

	int saleDetId ;
	int bookId ;
	int CustId ;
	double bookPrice;
	
		
	public SaleDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SaleDetails(int saleDetId, int bookId, int custId, double bookPrice) {
		super();
		this.saleDetId = saleDetId;
		this.bookId = bookId;
		CustId = custId;
		this.bookPrice = bookPrice;
	}


	public int getSaleDetId() {
		return saleDetId;
	}


	public void setSaleDetId(int saleDetId) {
		this.saleDetId = saleDetId;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public int getCustId() {
		return CustId;
	}


	public void setCustId(int custId) {
		CustId = custId;
	}


	public double getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
	
	
	
	
}
