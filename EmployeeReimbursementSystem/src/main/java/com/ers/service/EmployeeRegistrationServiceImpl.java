package com.ers.service;

import com.ers.dao.EmployeeRegistrationDao;
import com.ers.dao.EmployeeRegistrationDaoImpl;
import com.ers.model.Employee;

public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService{
	
	EmployeeRegistrationDao employeeDao=new EmployeeRegistrationDaoImpl();
	 public void addEmployeeRecord(Employee e) {
		 employeeDao.addEmployeeRecord(e);
		 
	 }
	
	
}
