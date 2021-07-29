package com.revature.studentcourse.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.studentcourse.exception.CourseNotFoundException;
import com.revature.studentcourse.model.CourseModel;
import com.revature.studentcourse.service.CourseService;
import com.revature.studentcourse.service.CourseServiceImpl;

public class CourseController {

	static Logger logger = Logger.getLogger(CourseController.class);

	CourseService courseServiceImpl = new CourseServiceImpl();

	public void addCourse(CourseModel coursemodel) {

		logger.info("IN ADD COURSE METHOD-CONTROLLER");

		try {

			courseServiceImpl.addCourse(coursemodel);
		} catch (Exception e) {

		}

	}

	public void deleteCourse(CourseModel coursemodel) {

		logger.info("IN DELETE COURSE-CONTROLLER");
		try {

			courseServiceImpl.deleteCourse(coursemodel);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateCourse() {

		logger.info("IN UPDATE COURSE-CONTROLLER");

		try {

			courseServiceImpl.updateCourse();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<CourseModel> displayCourse() {

		logger.info("IN DISPLAY COURSE-CONTROLLER");

		return courseServiceImpl.displayCourse();

	}

	public void fetchFullCourseReport() {
		logger.info("IN FETCH COURSE REPORT-CONTROLLER");

		try {

			courseServiceImpl.fetchFullCourseReport();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fetchCourseReportById() throws CourseNotFoundException {

		logger.info("IN FETCH COURSE BY ID");

		try {

			courseServiceImpl.fetchCourseReportById();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
