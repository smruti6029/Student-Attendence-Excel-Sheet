package com.sa.service;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import com.sa.dto.AttendenceDto;
import com.sa.dto.AttendenceDtoV2;
import com.sa.entity.Attendence;

public interface AttendenceService {

	public Integer addAttendence(AttendenceDto attendenceDto);

	ByteArrayInputStream getdataBydate(String date);

	public ByteArrayInputStream getDatatoDatereport(Date date, Date date1);

}
