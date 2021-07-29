package com.revature.studentcourse.service;

import java.util.List;

import com.revature.studentcourse.exception.CourseNotFoundException;
import com.revature.studentcourse.exception.InvalidIDException;
import com.revature.studentcourse.model.CourseModel;

public interface CourseService {

	public void addCourse(CourseModel coursemodel);

	public void deleteCourse(CourseModel coursemodel);

	public void updateCourse();

	public List<CourseModel> displayCourse();

	public void fetchFullCourseReport();

	public void fetchCourseReportById() throws CourseNotFoundException, InvalidIDException;
}
