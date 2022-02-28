package com.book.entities;

public class Customer {

	long custId;
	String custName;
	String custAddress;
	//double balance;
	String custPassword;
	long phone;
	String custEmail;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(long custId, String custName, String custAddress, String custPassword, long phone,
			String custEmail) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custPassword = custPassword;
		this.phone = phone;
		this.custEmail = custEmail;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	
	
}
