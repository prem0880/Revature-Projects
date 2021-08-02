package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Employee;
import com.ers.service.EmployeeRegistrationServiceImpl;

public class EmployeeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pass");
		String des=request.getParameter("designation");
		String dep=request.getParameter("department");
		String email=request.getParameter("email");
		String type=request.getParameter("type");
		
		
		Employee employee = new Employee();
		
		int id1=Integer.parseInt(id);
		employee.setEmployeeId(id1);
		employee.setEmployeeName(name);
		employee.setEmployeePassword(pwd);
		employee.setEmployeeDesignation(des);
		employee.setEmployeeDepartment(dep);
		employee.setEmployeeEmail(email);
		employee.setEmployeeType(type);
		
		EmployeeRegistrationServiceImpl employeeService =new EmployeeRegistrationServiceImpl();
		employeeService.addEmployeeRecord(employee);
		out.println(" Registration / Sign up success");
	
	}

}
