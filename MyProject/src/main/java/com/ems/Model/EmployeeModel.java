package com.ems.Model;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmployeeModel {

	
	
	

	@Id
	private long id;

	@Size(min = 2, message = "Enter valid Name")
	private String empName;
	
	@Min(value=18, message="Employee Age must be equal or greater than 18")  
    @Max(value=45, message="Employee Age must be equal or less than 45") 
	private String empAge;
	@NotBlank(message = "Address must not be blank")
	private String empAddress;
	@NotBlank(message = "Salary must not be blank")
	private String empSalary;
	@NotBlank(message = "Manager must not be blank")
	private String empMan;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAge() {
		return empAge;
	}

	public void setEmpAge(String empAge) {
		this.empAge = empAge;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpMan() {
		return empMan;
	}

	public void setEmpMan(String empMan) {
		this.empMan = empMan;
	}

	
	
	
	
	
}
