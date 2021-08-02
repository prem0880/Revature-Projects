package com.ers.model;

public class Employee {

	private Integer employeeId;
	private String employeeName;
	private String employeePassword;
	private String employeeDesignation;
	private String employeeDepartment;
	private String employeeEmail;
	private String employeeType;

	
	public Employee() {
		super();
	}
	
	public Employee(Integer employeeId, String employeeName, String employeePassword, String employeeDesignation,
			String employeeDepartment, String employeeEmail, String employeeType) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
		this.employeeDesignation = employeeDesignation;
		this.employeeDepartment = employeeDepartment;
		this.employeeEmail = employeeEmail;
		this.employeeType = employeeType;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePassword="
				+ employeePassword + ", employeeDesignation=" + employeeDesignation + ", employeeDepartment="
				+ employeeDepartment + ", employeeEmail=" + employeeEmail + ", employeeType=" + employeeType + "]";
	}

	



}

