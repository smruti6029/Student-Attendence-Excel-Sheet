package com.sa.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sa.entity.Student;

@Transactional
@Repository
public class StudentDaoImp implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer saveStudent(List<Student> students) {
		try {
			students.forEach(sessionFactory.getCurrentSession()::save);

		} catch (Exception e) {
			return 0;
		}
		sessionFactory.getCurrentSession().close();
		return 1;
	}

}
