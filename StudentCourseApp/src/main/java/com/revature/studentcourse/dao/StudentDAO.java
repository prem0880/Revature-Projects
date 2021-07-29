package com.revature.studentcourse.dao;

import java.util.List;

import com.revature.studentcourse.model.StudentModel;

public interface StudentDAO {

	public void addStudent(StudentModel studentmodel);

	public void deleteStudent(StudentModel studentmodel);

	public void updateStudent(StudentModel studentmodel);

	public List<StudentModel> displayStudent();
}
