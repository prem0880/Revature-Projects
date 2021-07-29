package com.revature.studentcourse.exception;

import org.apache.log4j.Logger;

public class InvalidSwitchChoiceException extends Exception {

	static Logger logger = Logger.getLogger(InvalidSwitchChoiceException.class);

	public InvalidSwitchChoiceException(String msg) {
		super(msg);
		logger.info("Inside Invalid Switch Choice Exception");
	}

}
