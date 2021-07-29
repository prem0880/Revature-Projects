package com.revature.studentcourse.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.revature.studentcourse.dao.StudentDAO;
import com.revature.studentcourse.dao.StudentDAOImpl;
import com.revature.studentcourse.model.StudentModel;
import com.revature.studentcourseutil.DBUtil;

public class StudentDAOImplTest {

	static Logger logger=Logger.getLogger("StudentDAOImplTest.class");
	@Test
	public void testAddStudent() {
		
		logger.info("Inside Test Add Student");
		
		StudentDAO studentDAOImpl = new StudentDAOImpl();

		StudentModel studentmodel = new StudentModel();

		long initialCount = 0;

		long finalCount = 0;

		try (Connection con = DBUtil.getConnection();) {

			Statement st = con.createStatement();

			ResultSet rs = null;

			System.out.println("Before Insert");

			rs = st.executeQuery("select * from Student");

			while (rs.next()) {
				initialCount++;
			}

			System.out.println(initialCount);

			studentmodel.setStudentId(3);
			studentmodel.setStudentFirstName("Jim");
			studentmodel.setStudentLastName("Halpart");
			studentmodel.setStudentEmail("jim@office_nbc");
			studentmodel.setStudentPhone(98772134);
			studentmodel.setStudentAddress("chicago");
			
			studentDAOImpl.addStudent(studentmodel);
			
			System.out.println("After Insert");

			rs = st.executeQuery("select * from Student");

			while (rs.next()) {
				finalCount++;
			}
			System.out.println(finalCount);

		} catch (Exception e) {

		}

		assertNotSame(initialCount, finalCount);


	
	}

	@Test
	public void testDeleteStudent() {
		
		
		logger.info("Inside Test Delete Student");
		
		StudentDAO studentDAOImpl = new StudentDAOImpl();

		StudentModel studentmodel = new StudentModel();

		long initialCount = 0;

		long finalCount = 0;

		try (Connection con = DBUtil.getConnection();) {

			Statement st = con.createStatement();

			ResultSet rs = null;

			System.out.println("Before Insert");

			rs = st.executeQuery("select * from Student");

			while (rs.next()) {
				initialCount++;
			}

			System.out.println(initialCount);

			studentmodel.setStudentId(3);
			
			studentDAOImpl.deleteStudent(studentmodel);
			
			System.out.println("After Insert");

			rs = st.executeQuery("select * from Student");

			while (rs.next()) {
				finalCount++;
			}
			System.out.println(finalCount);

		} catch (Exception e) {

		}

		assertNotSame(initialCount, finalCount);


	}


	@Test
	public void testDisplayStudent() {
		
		logger.info("Inside Test Display Student");
		
		boolean flag = false;
		
		try {
			Connection con = DBUtil.getConnection();
			Statement pst = con.createStatement();
			ResultSet rs = pst.executeQuery("select * from Student");

			if (rs.next()) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(flag);
	
	}

}
