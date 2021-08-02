package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ers.db.DBUtil;
import com.ers.model.Employee;

public class EmployeeLoginDaoImpl implements EmployeeLoginDao{

	@Override
	public boolean checkLogin(Employee e) {
		boolean status = false;
		try {
			Connection con=DBUtil.getConnection();
			
			PreparedStatement pst=con.prepareStatement("select * from Employee where EmployeeId=? and EmployeePassword=?");
			pst.setInt(1,e.getEmployeeId());
			pst.setString(2, e.getEmployeePassword());
			ResultSet rs=pst.executeQuery();  
			status=rs.next();  
			
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		return status;
	}
	
	
}
