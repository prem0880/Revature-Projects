package com.revature.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.studentcourse.exception.CourseNotFoundException;
import com.revature.studentcourse.exception.InvalidIDException;
import com.revature.studentcourse.model.StudentModel;
import com.revature.studentcourseutil.DBUtil;

public class StudentDAOImpl implements StudentDAO {

	Scanner sc=new Scanner(System.in);
	
	static Logger log = Logger.getLogger(StudentDAOImpl.class);

	List<StudentModel> smodel = new ArrayList<StudentModel>();

	public void addStudent(StudentModel studentmodel) {

		log.info("in add student DAO Implementation...");
		try {

			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("insert into Student values(?,?,?,?,?,?)");
			pst.setInt(1, studentmodel.getStudentId());
			pst.setString(2, studentmodel.getStudentFirstName());
			pst.setString(3, studentmodel.getStudentLastName());
			pst.setString(4, studentmodel.getStudentEmail());
			pst.setInt(5, studentmodel.getStudentPhone());
			pst.setString(6, studentmodel.getStudentAddress());
			pst.execute();
			System.out.println("Data inserted..");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent(StudentModel studentmodel) {

		log.info("in delete student DAO Implementation...");

		try {

			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("delete  from Student where studentId = ?");
			pst.setInt(1, studentmodel.getStudentId());
			pst.executeUpdate();
			System.out.println("Data deleted..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(StudentModel studentmodel) {
		log.info("in update student DAO Implementation...");
		
		try {

			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"update Student set studentFirstName=?,studentLastName=?,studentEmail=?,studentPhone=?,studentAddress=? where studentId=?");
			pst.setString(1, studentmodel.getStudentFirstName());
			pst.setString(2, studentmodel.getStudentLastName());
			pst.setString(3, studentmodel.getStudentEmail());
			pst.setInt(4, studentmodel.getStudentPhone());
			pst.setString(5, studentmodel.getStudentAddress());
			pst.setInt(6, studentmodel.getStudentId());
			pst.executeUpdate();
			System.out.println("Data updated..");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	@Override
	public List<StudentModel> displayStudent() {
		log.info("in display student DAO Implementation...");

		try {

			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Student");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				StudentModel studentmodel = new StudentModel();
				studentmodel.setStudentId(rs.getInt(1));
				studentmodel.setStudentFirstName(rs.getString(2));
				studentmodel.setStudentLastName(rs.getString(3));
				studentmodel.setStudentEmail(rs.getString(4));
				studentmodel.setStudentPhone(rs.getInt(5));
				studentmodel.setStudentAddress(rs.getString(6));

				smodel.add(studentmodel);

			}
			System.out.println("Data displayed..");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return smodel;
	}

}
