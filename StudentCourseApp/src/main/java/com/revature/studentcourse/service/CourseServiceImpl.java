package com.revature.studentcourse.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.studentcourse.dao.CourseDAO;
import com.revature.studentcourse.dao.CourseDAOImpl;
import com.revature.studentcourse.exception.CourseNotFoundException;
import com.revature.studentcourse.exception.InvalidIDException;
import com.revature.studentcourse.model.CourseModel;

public class CourseServiceImpl implements CourseService {

	static Logger logger = Logger.getLogger(CourseServiceImpl.class);

	CourseDAO courseDAOImpl = new CourseDAOImpl();

	@Override
	public void addCourse(CourseModel coursemodel) {
		logger.info("IN ADD COURSE-SERVICE");

		try {

			courseDAOImpl.addCourse(coursemodel);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteCourse(CourseModel coursemodel) {

		logger.info("IN DELETE COURSE-SERVICE");

		try {

			courseDAOImpl.deleteCourse(coursemodel);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCourse() {

		logger.info("IN UPDATE COURSE-SERVICE");

		try {

			courseDAOImpl.updateCourse();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CourseModel> displayCourse() {
		logger.info("IN DISPLAY COURSE-SERVICE");

		return courseDAOImpl.displayCourse();

	}

	@Override
	public void fetchFullCourseReport() {
		logger.info("IN FETCH COURSE REPORT-SERVICE");

		try {

			courseDAOImpl.fetchFullCourseReport();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fetchCourseReportById() throws CourseNotFoundException, InvalidIDException {

		logger.info("IN FETCH COURSE BY ID");

		try {

			courseDAOImpl.fetchCourseReportById();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
