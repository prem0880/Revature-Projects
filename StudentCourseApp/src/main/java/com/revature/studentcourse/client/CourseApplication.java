package com.revature.studentcourse.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.studentcourse.controller.CourseController;
import com.revature.studentcourse.exception.CourseNotFoundException;
import com.revature.studentcourse.exception.InvalidSwitchChoiceException;
import com.revature.studentcourse.model.CourseModel;

public class CourseApplication {

	static Logger logger = Logger.getLogger(CourseApplication.class);


	public void CourseApp() throws InvalidSwitchChoiceException {
	
		logger.info("IN COURSE APP");

		Scanner sc = new Scanner(System.in);

		int ch = 0;
		
		do{
			System.out.println("==========Student Course Application(ADMIN)===========" + "\n");

			CourseModel coursemodel = new CourseModel();

			CourseController coucontroller = new CourseController();

			System.out.println("1.CREATE/ADDING COURSES" + "\n" + "2.REMOVE COURSES" + "\n" + "3.UPDATE COURSES" + "\n"
					+ "4.DISPLAY COURSES" + "\n" + "5.FETCH FULL COURSE REPORT" + "\n" + "6.FETCH COURSE REPORT BY ID"
					+ "\n" + "7.EXIT THE MODULE");
			System.out.println("Enter the choice" + "\n");

			ch = sc.nextInt();

			switch (ch) {

			case 1: {
				logger.info("Inside Case 1");
				System.out.println("OPERATION-CREATION OF COURSE RECORDS");
				System.out.println("Enter the Course ID");
				int courseid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Course Name");
				String coursename = sc.nextLine();
				System.out.println("Enter the Course Duration");
				int courseduration = sc.nextInt();
				System.out.println("Enter the Student ID to enroll");
				int studentid = sc.nextInt();

				coursemodel.setCourse_id(courseid);
				coursemodel.setCourse_name(coursename);
				coursemodel.setCourse_duration(courseduration);
				coursemodel.setStudent_id(studentid);

				System.out.println(coursemodel);

				coucontroller.addCourse(coursemodel);

				System.out.println(" Use case 1- Adding Course Records is completed.");
				break;
			}

			case 2: {
				logger.info("Inside Case 2");
				System.out.println("OPERATION-DELETION OF COURSE RECORDS");
				System.out.println("Enter the Course ID");
				int courseid = sc.nextInt();
				// sc.nextLine();

				coursemodel.setCourse_id(courseid);

				coucontroller.deleteCourse(coursemodel);

				System.out.println(" Use case 2- Deleting Course Record is completed.");
				break;
			}

			case 3: {
				logger.info("Inside Case 3");
				System.out.println("OPERATION-UPDATION OF COURSE RECORDS");

				coucontroller.updateCourse();

				System.out.println(" Use case 3- Updating Course Records is completed.");
				break;
			}
			case 4: {
				logger.info("Inside Case 4");
				System.out.println("OPERATION-DISPLAYING OF COURSE RECORDS");

				System.out.println(coucontroller.displayCourse());

				System.out.println(" Use case 4- Displaying Course Record is completed.");
				break;

			}

			case 5: {
				logger.info("Inside Case 5");
				System.out.println("OPERATION-FETCHING FULL COURSE REPORT");

				coucontroller.fetchFullCourseReport();

				break;
			}

			case 6: {
				logger.info("Inside Case 6");
				System.out.println("OPERATION-FETCHING COURSE REPORT BY ID");

				try {
					coucontroller.fetchCourseReportById();
				} catch (CourseNotFoundException e) {
					e.printStackTrace();
				}

				break;

			}

			case 7: {
				logger.info("Inside Case 7");
				break;
			}

//			default:
//				throw new InvalidSwitchChoiceException("Invalid Switch case");

			}

		}while(ch<7);

	}
}


