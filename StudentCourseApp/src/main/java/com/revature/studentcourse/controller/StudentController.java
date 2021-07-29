package com.revature.studentcourse.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.studentcourse.model.StudentModel;

import com.revature.studentcourse.service.StudentService;
import com.revature.studentcourse.service.StudentServiceImpl;

public class StudentController {

	static Logger log = Logger.getLogger(StudentController.class);

	StudentService studentServiceImpl = new StudentServiceImpl();

	public void addStudent(StudentModel studentmodel) {
		log.info("in add student controller");
		try {

			studentServiceImpl.addStudent(studentmodel);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void deleteStudent(StudentModel studentmodel) {
		log.info("in delete student controller");
		try {
			studentServiceImpl.deleteStudent(studentmodel);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void updateStudent(StudentModel studentmodel) {
		log.info("in update student controller");
		try {
			studentServiceImpl.updateStudent(studentmodel);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public List<StudentModel> displayStudent() {
		log.info("in display student controller");

		return studentServiceImpl.displayStudent();

	}

}
