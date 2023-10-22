package com.files.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User 
{
	
	private int id;
	private String companyName;
	
	private String CompanyAddress;
	private String RegisterNumber;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", companyName=" + companyName + ", CompanyAddress=" + CompanyAddress
				+ ", RegisterNumber=" + RegisterNumber + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", email=" + email + ", password=" + password + ", typesOfRole=" + typesOfRole + "]";
	}
	public User(int id, String companyName, String companyAddress, String registerNumber, String firstName,
			String lastName, String email, String password, String typesOfRole) {
		super();
		this.id = id;
		this.companyName = companyName;
		CompanyAddress = companyAddress;
		RegisterNumber = registerNumber;
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
		this.password = password;
		this.typesOfRole = typesOfRole;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return CompanyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		CompanyAddress = companyAddress;
	}
	public String getRegisterNumber() {
		return RegisterNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		RegisterNumber = registerNumber;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
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
	private String FirstName;
	private String LastName;
	@Id
	private String email;
	private String password;
	private String typesOfRole;

}
