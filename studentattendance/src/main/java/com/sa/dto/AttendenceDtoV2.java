package com.sa.dto;


import java.util.Date;



public class AttendenceDtoV2 {

	public String name;
	
	public String status;
	
	public Date date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AttendenceDtoV2(String name, String status, Date date) {
		super();
		this.name = name;
		this.status = status;
		this.date = date;
	}

	public AttendenceDtoV2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
