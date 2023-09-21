package com.sa.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sa.entity.Attendence;

@Repository
@Transactional
public class AttendenceDaoImp implements AttendenceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer saveAttendence(Attendence attendence) {
		try {
			sessionFactory.getCurrentSession().save(attendence);
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<Attendence> getbyDate(Date date) {
		String hql = "FROM Attendence a WHERE a.date = :date";

		List<Attendence> attendenceList = sessionFactory.getCurrentSession().createQuery(hql, Attendence.class)
				.setParameter("date", date).list();

		return attendenceList;

	}

	@Override
	public List<Attendence> getdatadatetoDate(Date date, Date date1) {
		Criteria criteria= sessionFactory.getCurrentSession().createCriteria(Attendence.class);
		criteria.add(Restrictions.between("date",date, date1));
		return criteria.list();
		
		
	}

}
