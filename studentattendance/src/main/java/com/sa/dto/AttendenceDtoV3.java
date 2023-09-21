package com.sa.dto;


import java.util.Date;



public class AttendenceDtoV3 {

	private String updatedBy;

	private Date date;

	private Boolean attendence;

	private StudentDto student;

	public AttendenceDtoV3() {
		super();
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getAttendence() {
		return attendence;
	}

	public void setAttendence(Boolean attendence) {
		this.attendence = attendence;
	}

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "AttendenceDtoV2 [updatedBy=" + updatedBy + ", date=" + date + ", attendence=" + attendence
				+ ", student=" + student + "]";
	}

}
