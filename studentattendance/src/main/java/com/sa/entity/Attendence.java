package com.sa.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attendence 
	{ 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String updatedBy;
	

	private Date date;
	
	private Boolean attendence;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Attendence(Integer id, String updatedBy, Date date, Boolean attendence, Student student) {
		super();
		this.id = id;
		this.updatedBy = updatedBy;
		this.date = date;
		this.attendence = attendence;
		this.student = student;
	}

	public Attendence(Boolean attendence, Date date, Student student, String updatedBy) {
		super();
		this.updatedBy = updatedBy;
		this.date = date;
		this.attendence = attendence;
		this.student = student;
	}

	public Attendence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	}
