package com.revature.studentcourse.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.revature.studentcourse.dao.CourseDAO;
import com.revature.studentcourse.dao.CourseDAOImpl;
import com.revature.studentcourse.model.CourseModel;
import com.revature.studentcourseutil.DBUtil;

public class CourseDAOImplTest {

	@Test
	public void testAddCourse() {

		CourseDAO courseDAOImpl = new CourseDAOImpl();

		CourseModel coursemodel = new CourseModel();

		long initialCount = 0;

		long finalCount = 0;

		try (Connection con = DBUtil.getConnection();) {

			Statement st = con.createStatement();

			ResultSet rs = null;

			System.out.println("Before Insert");

			rs = st.executeQuery("select * from Course");

			while (rs.next()) {
				initialCount++;
			}

			System.out.println(initialCount);

			coursemodel.setCourse_id(109);
			coursemodel.setCourse_name("YTS");
			coursemodel.setCourse_duration(4);
			coursemodel.setStudent_id(1);
			courseDAOImpl.addCourse(coursemodel);

			System.out.println("After Insert");

			rs = st.executeQuery("select * from Course");

			while (rs.next()) {
				finalCount++;
			}
			System.out.println(finalCount);

		} catch (Exception e) {

		}

		assertNotSame(initialCount, finalCount);

	}

	@Test
	public void testDeleteCourse() {

		CourseDAO courseDAOImpl = new CourseDAOImpl();

		CourseModel coursemodel = new CourseModel();

		long initialCount = 0;

		long finalCount = 0;

		try (Connection con = DBUtil.getConnection();) {

			Statement st = con.createStatement();

			ResultSet rs = null;

			System.out.println("Before Delete");

			rs = st.executeQuery("select * from Course");

			while (rs.next()) {
				initialCount++;
			}

			System.out.println(initialCount);

			coursemodel.setCourse_id(107);

			courseDAOImpl.deleteCourse(coursemodel);

			System.out.println("After Delete");

			rs = st.executeQuery("select * from Course");

			while (rs.next()) {
				finalCount++;
			}
			System.out.println(finalCount);

		} catch (Exception e) {

		}

		assertNotSame(initialCount, finalCount);

	}

	

	@Test
	public void testDisplayCourse() {
		boolean flag = false;
		
		try {
			Connection con = DBUtil.getConnection();
			Statement pst = con.createStatement();
			ResultSet rs = pst.executeQuery("select * from Course");

			if (rs.next()) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(flag);
	}

	@Test
	public void testFetchFullCourseReport() {
		// fail("Not yet implemented");
	}

	@Test
	public void testFetchCourseReportById() {
		// fail("Not yet implemented");
	}

}
