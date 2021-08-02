package com.ers.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Employee;
import com.ers.service.EmployeeLoginService;
import com.ers.service.EmployeeLoginServiceImpl;

public class EmployeeLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String id=request.getParameter("uname");
		String pwd=request.getParameter("psw");
		
		Employee employee = new Employee();
		
		int id1=Integer.parseInt(id);
		employee.setEmployeeId(id1);
		employee.setEmployeePassword(pwd);
		
		EmployeeLoginService employeeLogin =new EmployeeLoginServiceImpl();
		boolean status=employeeLogin.checkLogin(employee);
		
		 if(status == true){  
		       	System.out.println("Username and Password are matched!!!");
			 	RequestDispatcher rd=request.getRequestDispatcher("LoginSuccess.html");  
		        rd.forward(request,response);  
		    }  
		    else{  
		        System.out.print("Sorry username or password error");  
		        RequestDispatcher rd=request.getRequestDispatcher("Login.html");  
		        rd.include(request,response);  
		    }  
		
		
	}

}
