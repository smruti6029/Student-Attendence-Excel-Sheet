package com.sa.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sa.entity.Attendence;
import com.sa.entity.Student;

public class AttendenceDto {

	private String updatedBy;

	private String date;

	private Boolean attendence;

	private Student student;

	public AttendenceDto() {
		super();
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getAttendence() {
		return attendence;
	}

	public void setAttendence(Boolean attendence) {
		this.attendence = attendence;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public AttendenceDto(String updatedBy, String date, Boolean attendence, Student student) {
		super();
		this.updatedBy = updatedBy;
		this.date = date;
		this.attendence = attendence;
		this.student = student;
	}

	public Attendence convertToentity(AttendenceDto attendenceDto) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

		Date date = dateFormat.parse(attendenceDto.getDate());

		String format = dateFormat.format(date);
		Date dateFormats = dateFormat.parse(format);
		Date date2 = dateFormat.parse(format);

		return new Attendence(attendenceDto.getAttendence(), date2, attendenceDto.getStudent(),
				attendenceDto.getUpdatedBy());

	}

}
