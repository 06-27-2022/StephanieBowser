package com.revature1.model;

import java.util.Objects;

public class Reimburse {
	private Integer id;
	private String userName;
	private String amount;
	private String description;
	private String approval;
	
	public Reimburse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public String getApproval() {
		return approval;
	}


	public void setApproval(String approval) {
		this.approval = approval;
	}





	public Reimburse(Integer id, String userName, String amount, String description, String approval) {
		super();
		this.id = id;
		this.userName = userName;
		this.amount = amount;
		this.description = description;
		this.approval = approval;
	}




	@Override
	public int hashCode() {
		return Objects.hash(amount, approval, description, id, userName);
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
		return Objects.equals(amount, other.amount) && Objects.equals(approval, other.approval)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(userName, other.userName);
	}


	@Override
	public String toString() {
		return "Reimburse [id=" + id + ", userName=" + userName + ", amount=" + amount + ", description=" + description
				+ ", approval=" + approval + "]";
	}


	public void add(Reimburse reimburse) {
		// TODO Auto-generated method stub
		
	}

}
