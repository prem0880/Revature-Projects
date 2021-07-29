package com.revature.studentcourse.exception;

import org.apache.log4j.Logger;

public class CourseNotFoundException extends Exception {

	static Logger logger = Logger.getLogger(ClassNotFoundException.class);

	public CourseNotFoundException(String msg) {
		super(msg);
		logger.info("Inside Course Not Found Exception");

	}
}
