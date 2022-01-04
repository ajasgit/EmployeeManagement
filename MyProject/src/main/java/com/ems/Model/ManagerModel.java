package com.ems.Model;

import javax.persistence.Id;

public class ManagerModel {

	
	@Id
	public long id;
	public String manName;
	public String manAge;
	public String manAddress;
	public String manSalary;
	public String currentProject;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getManName() {
		return manName;
	}
	public void setManName(String manName) {
		this.manName = manName;
	}
	public String getManAge() {
		return manAge;
	}
	public void setManAge(String manAge) {
		this.manAge = manAge;
	}
	public String getManAddress() {
		return manAddress;
	}
	public void setManAddress(String manAddress) {
		this.manAddress = manAddress;
	}
	public String getManSalary() {
		return manSalary;
	}
	public void setManSalary(String manSalary) {
		this.manSalary = manSalary;
	}
	public String getCurrentProject() {
		return currentProject;
	}
	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}
	
	public ManagerModel(long id, String manName, String manAge, String manAddress, String manSalary,
			String currentProject) {
		super();
		this.id = id;
		this.manName = manName;
		this.manAge = manAge;
		this.manAddress = manAddress;
		this.manSalary = manSalary;
		this.currentProject = currentProject;
	}
	
	
	

	
}
