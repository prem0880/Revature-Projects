package com.revature.studentcourse.model;

public class CourseModel {

	private Integer Course_id;
	private String Course_name;
	private Integer Course_duration;
	private Integer Student_id;

	public Integer getCourse_id() {
		return Course_id;
	}

	public void setCourse_id(Integer course_id) {
		Course_id = course_id;
	}

	public String getCourse_name() {
		return Course_name;
	}

	public void setCourse_name(String course_name) {
		Course_name = course_name;
	}

	public Integer getCourse_duration() {
		return Course_duration;
	}

	public void setCourse_duration(Integer course_duration) {
		Course_duration = course_duration;
	}

	public Integer getStudent_id() {
		return Student_id;
	}

	public void setStudent_id(Integer student_id) {
		Student_id = student_id;
	}

	@Override
	public String toString() {
		return "CourseModel [Course_id=" + Course_id + ", Course_name=" + Course_name + ", Course_duration="
				+ Course_duration + ", Student_id=" + Student_id + "]";
	}

}
