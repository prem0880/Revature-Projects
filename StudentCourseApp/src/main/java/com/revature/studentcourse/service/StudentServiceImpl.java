package com.revature.studentcourse.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.studentcourse.dao.StudentDAO;
import com.revature.studentcourse.dao.StudentDAOImpl;
import com.revature.studentcourse.model.StudentModel;

public class StudentServiceImpl implements StudentService {

	static Logger log = Logger.getLogger(StudentServiceImpl.class);

	StudentDAO studentDAOImpl = new StudentDAOImpl();

	@Override
	public void addStudent(StudentModel studentmodel) {

		log.info("in add student service implementation");
		try {
			studentDAOImpl.addStudent(studentmodel);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent(StudentModel studentmodel) {
		log.info("in delete student service implementation");
		try {
			studentDAOImpl.deleteStudent(studentmodel);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateStudent(StudentModel studentmodel) {
		log.info("in update student service implementation");

		try {
			studentDAOImpl.updateStudent(studentmodel);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<StudentModel> displayStudent() {

		log.info("in display student service implementation");

		return studentDAOImpl.displayStudent();

	}

}
