package com.revature.studentcourse.model;

public class StudentModel {
	private Integer StudentId;
	private String StudentFirstName;
	private String StudentLastName;
	private String StudentEmail;
	private Integer StudentPhone;
	private String StudentAddress;

	public Integer getStudentId() {
		return StudentId;
	}

	public void setStudentId(Integer studentId) {
		StudentId = studentId;
	}

	public String getStudentFirstName() {
		return StudentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		StudentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return StudentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		StudentLastName = studentLastName;
	}

	public String getStudentEmail() {
		return StudentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}

	public Integer getStudentPhone() {
		return StudentPhone;
	}

	public void setStudentPhone(Integer studentPhone) {
		StudentPhone = studentPhone;
	}

	public String getStudentAddress() {
		return StudentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "StudentCourseRepo [StudentId=" + StudentId + ", StudentFirstName=" + StudentFirstName
				+ ", StudentLastName=" + StudentLastName + ", StudentEmail=" + StudentEmail + ", StudentPhone="
				+ StudentPhone + ", StudentAddress=" + StudentAddress + "]";
	}

}
