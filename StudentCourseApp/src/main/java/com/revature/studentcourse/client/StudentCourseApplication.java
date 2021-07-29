package com.revature.studentcourse.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.studentcourse.exception.InvalidSwitchChoiceException;

public class StudentCourseApplication {

	static Logger logger=Logger.getLogger(StudentApplication.class);
			
	public static void main(String[] args) throws InvalidSwitchChoiceException {

		logger.info("In Main Method...");
		
		Scanner sc = new Scanner(System.in);
		
		StudentApplication studentapplication=new StudentApplication();
		
		CourseApplication courseapplication=new CourseApplication();
		
		
		
		for(;;) {

			System.out.println("\n"+"-----------STUDENT COURSE MANAGEMENT SYSTEM------------"+"\n");
			
			System.out.println(
					"1.Student Module" + "\n" + "2.Instructor's Course Module" + "\n" + "3.Exit The Application"+"\n");
			int ch = 0;

			System.out.println("Enter the choice" + "\n");
			
			ch = sc.nextInt();
	
			
			
		switch(ch)
		{
		

		case 1:	
				logger.info("In Main Student Case");
				
				System.out.println("Entering Student Module....");
		
				studentapplication.StudentApp();
				
				break;
		
		case 2:
				
				logger.info("In Main Course Case");
			
				System.out.println("Entering Course Module....");
	
				courseapplication.CourseApp();
			
				break;
		
		case 3:
				logger.info("Exiting Application");
				//sc.close();
				System.exit(0);
		
		
		default: throw new InvalidSwitchChoiceException("Please Enter a Valid Choice");
		
		}
		
		}
		
	}

}
