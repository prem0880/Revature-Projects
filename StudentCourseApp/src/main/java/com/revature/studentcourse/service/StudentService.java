package com.revature.studentcourse.service;

import java.util.List;

import com.revature.studentcourse.model.StudentModel;

public interface StudentService {

	public void addStudent(StudentModel studentmodel);

	public void deleteStudent(StudentModel studentmodel);

	public void updateStudent(StudentModel studentmodel);

	public List<StudentModel> displayStudent();
}
