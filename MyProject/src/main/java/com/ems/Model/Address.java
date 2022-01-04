package com.ems.Model;

import java.io.Serializable;

public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String houseName;
	public String streetName;
	public String post;
	public String state;
	public String pin;
	
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public Address(String houseName, String streetName, String post, String state, String pin) {
		super();
		this.houseName = houseName;
		this.streetName = streetName;
		this.post = post;
		this.state = state;
		this.pin = pin;
	}
	
	public Address() {
		super();
	}
	
	
	
	
}
