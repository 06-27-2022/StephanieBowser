package com.revature1.model;

import java.io.InputStream;
import java.util.Objects;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private boolean manager;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String firstName, String lastName, String userName, String password, boolean manager) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.manager= manager; 
	}


	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, manager, password, userName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& manager == other.manager && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName);
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Boolean getManager() {
		return manager;
	}


	public void setManager(boolean manager) {
		this.manager = manager;
	}
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", manager=" + manager + "]";
	}

}