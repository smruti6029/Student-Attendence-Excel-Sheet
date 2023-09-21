package com.sa.dto;

import com.sa.entity.Student;

public class StudentDto {
	
		
	private String name;
	
	private String addreass;
	
	private String phone;
		
	private Boolean is_active;
	
	private String updatedBy;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddreass() {
		return addreass;
	}

	public void setAddreass(String addreass) {
		this.addreass = addreass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public StudentDto(String name, String addreass, String phone, Boolean is_active, String updatedBy) {
		super();
		this.name = name;
		this.addreass = addreass;
		this.phone = phone;
		this.is_active = is_active;
		this.updatedBy = updatedBy;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Student convertEntity(StudentDto studentDto)
	{
//		Student student=new Student();
//		
//		student.setName(studentDto.getName());
//		student.setAddreass(studentDto.getAddreass());
//		student.setIs_active(studentDto.getIs_active());
//		student.setUpdatedBy(studentDto.getUpdatedBy());
//		student.setPhone(studentDto.getPhone());
		
		return new Student(studentDto.getName(),studentDto.getAddreass(),studentDto.getIs_active(),studentDto.getUpdatedBy(),studentDto.getPhone());
	}
	
	

}
