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
import com.revature.studentcourse.model.CourseModel;
import com.revature.studentcourseutil.DBUtil;

public class CourseDAOImpl implements CourseDAO {

	static Logger logger = Logger.getLogger(CourseDAOImpl.class);

	List<CourseModel> cmodel = new ArrayList<CourseModel>();

	Scanner sc = new Scanner(System.in);

	@Override
	public void addCourse(CourseModel coursemodel) {

		logger.info("IN ADD COURSE-DAOImpl");

		try {

			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("insert into Course values(?,?,?,?)");
			pst.setInt(1, coursemodel.getCourse_id());
			pst.setString(2, coursemodel.getCourse_name());
			pst.setInt(3, coursemodel.getCourse_duration());
			pst.setInt(4, coursemodel.getStudent_id());
			pst.execute();
			System.out.println("Data inserted...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCourse(CourseModel coursemodel) {

		logger.info("IN DELETE COURSE-DAOImpl");

		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("delete from Course where courseId=?");
			pst.setInt(1, coursemodel.getCourse_id());
			pst.executeUpdate();
			System.out.println("Data deleted...");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCourse() {

		logger.info("IN UPDATE COURSE-DAOImpl");

		try {
			
			System.out.println("Enter the Course ID");
			int courseid = sc.nextInt();
			
			if (courseid < 200) {
				throw new InvalidIDException("Enter Valid ID");
			}

			CheckCourseID(courseid);

			
			System.out.println("\n"+"Fields     			 -  Update Status Code");
			System.out.println("Course Name       			   - 1");
			System.out.println("Course Duration   			   - 2");
			System.out.println("Student ID of Enrolled Student		   - 3");
			
			System.out.println("Enter the update status code to update which details");
			
			int statuscode=sc.nextInt();
			
			switch(statuscode) {
			
			case 1:{
				try(Connection con = DBUtil.getConnection();) {
					
					System.out.println("To Update The Course Name");
					
					
					System.out.println("Enter the Course Name");
					String coursename = sc.nextLine();
					
					
										
					PreparedStatement pst=con.prepareStatement("update Course set courseName=? where courseId=?");
					
					pst.setString(1, coursename);
					pst.setInt(2, courseid);
					
					pst.executeUpdate();
					
					System.out.println("Course Name Data is updated...");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
				}
				
			case 2:{
				try(Connection con = DBUtil.getConnection();) {
					
					System.out.println("To Update The Course Duration");
					
					
					System.out.println("Enter the Course Duration");
					int courseduration = sc.nextInt();
					

					PreparedStatement pst=con.prepareStatement("update Course set courseDuration=? where courseId=?");
					
					pst.setInt(1, courseduration);
					pst.setInt(2, courseid);
					
					pst.executeUpdate();
					
					System.out.println("Course Duration Data is updated...");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
				}
			case 3:{
				try(Connection con = DBUtil.getConnection();) {
					
					System.out.println("To Update The Student ID-ENSURE THAT ID EXISTS IN STUDENT RECORDS");
					
					
					System.out.println("Enter the Student ID");
					int studentid = sc.nextInt();
					

					PreparedStatement pst=con.prepareStatement("update Course set studentId=? where courseId=?");
					
					pst.setInt(1,courseid);
					pst.setInt(2,studentid);
					
					pst.executeUpdate();
					
					System.out.println("Course's Student Data is updated...");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
				}
				
			
				}
			
			
			}
			
			catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<CourseModel> displayCourse() {
		logger.info("IN DISPLAY COURSE-DAOImpl");

		try {

			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Course");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				CourseModel course = new CourseModel();
				course.setCourse_id(rs.getInt(1));
				course.setCourse_name(rs.getString(2));
				course.setCourse_duration(rs.getInt(3));
				course.setStudent_id(rs.getInt(4));

				cmodel.add(course);

			}
			System.out.println("Data displayed..");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmodel;
	}

	@Override
	public void fetchFullCourseReport() {

		logger.info("IN FETCH COURSE REPORT-DAOImpl");

		try {

			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"SELECT s.studentId,s.studentFirstName,s.studentLastName,s.studentEmail,s.studentPhone,s.studentAddress,c.courseId,c.courseName,c.courseDuration from Student s inner join Course c on s.studentId=c.studentId ");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				System.out.println("Student ID:" + rs.getInt(1));
				System.out.println("Student First Name:" + rs.getString(2));
				System.out.println("Student Last Name:" + rs.getString(3));
				System.out.println("Student Email:" + rs.getString(4));
				System.out.println("Student Phone:" + rs.getInt(5));
				System.out.println("Student Address:" + rs.getString(6));
				System.out.println("Course ID:" + rs.getInt(7));
				System.out.println("Course Title:" + rs.getString(8));
				System.out.println("Course Duration:" + rs.getInt(9) + "\n");

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void CheckCourseID(Integer id) throws CourseNotFoundException {
		logger.info("Inside CheckCourseID");
		Boolean flag = false;
		List<Integer> u = new ArrayList<Integer>();
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Course");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				u.add(rs.getInt(1));
			}

		} catch (Exception e) {

		}
		Iterator<Integer> it = u.iterator();
		while (it.hasNext()) {
			if (id != it.next()) {
				flag = true;
				break;
			}
		}
	
		//System.out.println(flag);
		
		if (flag == false) {
			throw new CourseNotFoundException("Course ID not found on db");

		}

	}

	@Override
	public void fetchCourseReportById() {

		logger.info("INSIDE FETCH COURSE BY ID-DAOImpl");

		try (Connection con = DBUtil.getConnection();) {

			System.out.println("Enter the Course ID");

			Integer id = Integer.parseInt(sc.nextLine());

			if (id < 200) {
				throw new InvalidIDException("Enter Valid ID");
			}

			CheckCourseID(id);

			PreparedStatement pst = con.prepareStatement("SELECT s.studentId,s.studentFirstName,s.studentLastName,s.studentEmail,s.studentPhone,s.studentAddress,c.courseId,c.courseName,c.courseDuration from Student s inner join Course c on s.studentId=c.studentId where courseId=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println("\n" + "Student ID:" + rs.getInt(1));
				System.out.println("Student First Name:" + rs.getString(2));
				System.out.println("Student Last Name:" + rs.getString(3));
				System.out.println("Student Email:" + rs.getString(4));
				System.out.println("Student Phone:" + rs.getInt(5));
				System.out.println("Student Address:" + rs.getString(6));
				System.out.println("Course ID:" + rs.getInt(7));
				System.out.println("Course Title:" + rs.getString(8));
				System.out.println("Course Duration:" + rs.getInt(9) + "\n");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
