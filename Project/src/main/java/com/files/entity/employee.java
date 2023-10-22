package com.files.entity;

import javax.annotation.Generated;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Employee")
public class employee {
    
	
	
	private int eid;
	
	private String FirstName;
	private String companyName;

	private String LastName;
	@Id
	private String email;
	private String password;
	private String typesOfRole;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTypesOfRole() {
		return typesOfRole;
	}
	public void setTypesOfRole(String typesOfRole) {
		this.typesOfRole = typesOfRole;
	}
	public employee(int eid, String firstName, String companyName, String lastName, String email, String password,
			String typesOfRole) {
		super();
		this.eid = eid;
		FirstName = firstName;
		this.companyName = companyName;
		LastName = lastName;
		this.email = email;
		this.password = password;
		this.typesOfRole = typesOfRole;
	}
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "employee [eid=" + eid + ", FirstName=" + FirstName + ", companyName=" + companyName + ", LastName="
				+ LastName + ", email=" + email + ", password=" + password + ", typesOfRole=" + typesOfRole + "]";
	}
	
	
}
