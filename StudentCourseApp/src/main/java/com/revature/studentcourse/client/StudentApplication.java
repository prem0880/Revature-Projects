package com.revature.studentcourse.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.studentcourse.controller.StudentController;
import com.revature.studentcourse.exception.InvalidSwitchChoiceException;
import com.revature.studentcourse.model.StudentModel;

public class StudentApplication
{
	
	static Logger logger = Logger.getLogger(StudentApplication.class);
	
	public void StudentApp() throws InvalidSwitchChoiceException {
	
		int ch = 0;
		
		do{
		
			Scanner sc = new Scanner(System.in);
			
			logger.info("In main method-StudentApplication");

			System.out.println("==========Student Details Application(ADMIN)===========" + "\n");

			StudentModel studentmodel = new StudentModel();

			StudentController stucontroller = new StudentController();

			System.out.println(
					"1.Create Student Records" + "\n" + "2.Remove Student Records" + "\n" + "3.Update Student Records"
							+ "\n" + "4.Display Student Records" + "\n" + "5.Exit The Module" + "\n");
			
			System.out.println("Enter the choice" + "\n");

			ch = sc.nextInt();

			switch (ch) {

			case 1: {
				logger.info("Inside Case 1");
				System.out.println("OPERATION-CREATION OF STUDENT RECORDS");
				System.out.println("Enter the Student ID");
				int studentid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Student First Name to Update");
				String studentfirstname = sc.nextLine();
				System.out.println("Enter the Student Last Name to Update");
				String studentlastname = sc.nextLine();
				System.out.println("Enter the Student Mail to Update");
				String studentemail = sc.nextLine();
				System.out.println("Enter the Student Phone to Update");
				Integer studentphone = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Student Address to Update");
				String studentaddress = sc.nextLine();

				studentmodel.setStudentId(studentid);
				studentmodel.setStudentFirstName(studentfirstname);
				studentmodel.setStudentLastName(studentlastname);
				studentmodel.setStudentEmail(studentemail);
				studentmodel.setStudentPhone(studentphone);
				studentmodel.setStudentAddress(studentaddress);

				stucontroller.addStudent(studentmodel);

				System.out.println(" Use case 1- Adding Student Records is completed.");
				break;
			}

			case 2: {
				logger.info("Inside Case 2");
				System.out.println("OPERATION-DELETION OF STUDENT RECORDS");
				System.out.println("Enter the student ID");
				int studentid = sc.nextInt();
				// sc.nextLine();

				studentmodel.setStudentId(studentid);

				stucontroller.deleteStudent(studentmodel);

				System.out.println(" Use case 2- Deleting Student Record is completed.");
				break;
			}

			case 3: {

				logger.info("Inside Case 3");


				System.out.println("OPERATION-UPDATION OF STUDENT RECORDS");

				System.out.println("Enter the Student ID to update");
				int studentid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Student First Name to Update");
				String studentfirstname = sc.nextLine();
				System.out.println("Enter the Student Last Name to Update");
				String studentlastname = sc.nextLine();
				System.out.println("Enter the Student Mail to Update");
				String studentemail = sc.nextLine();
				System.out.println("Enter the Student Phone to Update");
				Integer studentphone = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Student Address to Update");
				String studentaddress = sc.nextLine();

				studentmodel.setStudentId(studentid);
				studentmodel.setStudentFirstName(studentfirstname);
				studentmodel.setStudentLastName(studentlastname);
				studentmodel.setStudentEmail(studentemail);
				studentmodel.setStudentPhone(studentphone);
				studentmodel.setStudentAddress(studentaddress);

				stucontroller.updateStudent(studentmodel);

				System.out.println(" Use case 3- Updating Student Record is completed.");
				break;



			}
			case 4: {
				logger.info("Inside Case 4");

				System.out.println("OPERATION-DISPLAYING OF STUDENT RECORDS");

				System.out.println(stucontroller.displayStudent());

				System.out.println(" Use case 3- Displaying Student Record is completed.");
				break;

			}

			case 5: {
				logger.info("Inside Case 5");
				
				break;
				
			}

			//default:throw new InvalidSwitchChoiceException("Please enter a valid switch choice");

			}

		}while(ch<5);
		}
}

