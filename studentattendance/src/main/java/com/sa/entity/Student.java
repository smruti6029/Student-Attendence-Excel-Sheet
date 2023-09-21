package com.sa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sa.dto.StudentDto;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "student_name")
	private String name;

	private String addreass;

	private String phone;

	private String rollnumber;

	private Boolean is_active;

	@Column(name = "updatedBy")
	private String updatedBy;

	@OneToMany(mappedBy = "student")
	private List<Attendence> attendence;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
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

	public List<Attendence> getAttendence() {
		return attendence;
	}

	public void setAttendence(List<Attendence> attendence) {
		this.attendence = attendence;
	}

	public Student(Integer id, String name, String addreass, String phone, String rollnumber, Boolean is_active,
			String updatedBy) {
		super();
		this.id = id;
		this.name = name;
		this.addreass = addreass;
		this.phone = phone;
		this.rollnumber = rollnumber;
		this.is_active = is_active;
		this.updatedBy = updatedBy;
	}

	public Student() {
		super();
	}

	public Student(String name, String addreass, Boolean is_active, String updatedBy, String phone) {
		this.name = name;
		this.addreass = addreass;
		this.phone = phone;
		this.updatedBy = updatedBy;
		this.is_active = is_active;
	}

	public StudentDto convertToStudentDto() {
		return new StudentDto(this.getName(), this.getAddreass(), this.getPhone(), this.getIs_active(),
				this.getUpdatedBy());
	}

}
