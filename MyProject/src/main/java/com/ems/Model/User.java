package com.ems.Model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

	@Id
	private Long user_id;
	@NotNull
	@Size(min = 2, message = "First Name atleast 2 letter" )
	private String firstName;
	@Size(min = 1, message = "Last Name atleast 1 letter" )
	private String lastName;
	@Size(min = 2, message = "Father Name atleast 2 letter" )
	private String nameOffather;
	@Pattern(regexp = "^[0-9][10]*", message = "Enter Valid mobile Number")
	private String phone;

	@JsonFormat
    public Address address;

	private String userName;
	private String password;
	private String confirmPassword;
	
	
	
	
	
	public User() {
		super();
	}
	

	
	public User(Long user_id, String firstName, String lastName, String nameOffather, String phone, Address address,
			String userName, String password, String confirmPassword) {
		super();
		this.user_id = user_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nameOffather = nameOffather;
		this.phone = phone;
		this.address = address;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}



	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	public String getNameOffather() {
		return nameOffather;
	}
	public void setNameOffather(String nameOffather) {
		this.nameOffather = nameOffather;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}	

	
	

