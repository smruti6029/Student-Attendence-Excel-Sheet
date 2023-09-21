package com.sa.dao;

import java.util.Date;
import java.util.List;

import com.sa.entity.Attendence;

public interface AttendenceDao {

	public Integer saveAttendence(Attendence attendence);

	List<Attendence> getbyDate(Date date);

	public List<Attendence> getdatadatetoDate(Date date, Date date1);

}
