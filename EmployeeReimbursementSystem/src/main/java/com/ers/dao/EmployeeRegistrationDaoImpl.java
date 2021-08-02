package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ers.db.DBUtil;
import com.ers.model.Employee;

public class EmployeeRegistrationDaoImpl implements EmployeeRegistrationDao{

	@Override
	public void addEmployeeRecord(Employee e) {
		
	try {
		Connection con=DBUtil.getConnection();
		
		PreparedStatement pst=con.prepareStatement("insert into Employee values(?,?,?,?,?,?,?)");
		pst.setInt(1,e.getEmployeeId());
		pst.setString(2,e.getEmployeeName());
		pst.setString(3, e.getEmployeePassword());
		pst.setString(4, e.getEmployeeDesignation());
		pst.setString(5,e.getEmployeeDepartment());
		pst.setString(6,e.getEmployeeEmail()); 
		pst.setString(7,e.getEmployeeType());
		pst.execute();
		System.out.println("data inserted..");
		
	} catch (Exception e1) {

		e1.printStackTrace();
	}
	
	
	
	}	
	
	
}
