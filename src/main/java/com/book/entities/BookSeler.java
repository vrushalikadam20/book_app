package com.book.entities;

public class BookSeler {

	int salerId;
	String salerName;
	String Password;
	
	
	
	public BookSeler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookSeler(int salerId, String salerName, String password) {
		super();
		this.salerId = salerId;
		this.salerName = salerName;
		Password = password;
	}
	
	public int getSalerId() {
		return salerId;
	}
	public void setSalerId(int salerId) {
		this.salerId = salerId;
	}
	public String getSalerName() {
		return salerName;
	}
	public void setSalerName(String salerName) {
		this.salerName = salerName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}
