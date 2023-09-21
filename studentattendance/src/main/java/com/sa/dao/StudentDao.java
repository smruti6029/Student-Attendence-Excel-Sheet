package com.sa.dao;

import java.util.List;

import com.sa.entity.Student;

public interface StudentDao {

	Integer saveStudent(List<Student> students);

}
