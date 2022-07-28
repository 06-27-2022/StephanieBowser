package com.revature1.model;

import java.util.Objects;

public class Reimburse {
	private String userName;
	private String amount;
	private String description;
	
	public Reimburse() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getAmount() {
		return amount;
	}




	public void setAmount(String amount) {
		this.amount = amount;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}


	

	public Reimburse(String string) {
		// TODO Auto-generated constructor stub
	}




	public Reimburse(String userName, String amount, String description) {
		super();
		this.userName = userName;
		this.amount = amount;
		this.description = description;
	}




	@Override
	public int hashCode() {
		return Objects.hash(amount, description, userName);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimburse other = (Reimburse) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(description, other.description)
				&& Objects.equals(userName, other.userName);
	}




	public void add(Reimburse reimburse) {
		// TODO Auto-generated method stub
		
	}

}
