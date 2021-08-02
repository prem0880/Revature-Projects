package com.ers.service;

import com.ers.dao.EmployeeLoginDao;
import com.ers.dao.EmployeeLoginDaoImpl;
import com.ers.model.Employee;

public class EmployeeLoginServiceImpl implements EmployeeLoginService{

	EmployeeLoginDao login = new EmployeeLoginDaoImpl();
	@Override
	public boolean checkLogin(Employee e) {
	
		 return login.checkLogin(e);
		
	
	}	
	
}
