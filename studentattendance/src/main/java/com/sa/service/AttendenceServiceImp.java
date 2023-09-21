package com.sa.service;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.dao.AttendenceDao;
import com.sa.dto.AttendenceDto;
import com.sa.dto.AttendenceDtoV2;
import com.sa.entity.Attendence;
import com.sa.entity.Student;
import com.sa.helper.Helper;
import com.sa.utilityclass.DatelistCalculate;

@Service
public class AttendenceServiceImp implements AttendenceService {

	@Autowired
	private AttendenceDao attendenceDao;
	
	@Autowired
	private DatelistCalculate calculateDate;

	@Override
	public Integer addAttendence(AttendenceDto attendenceDto) {

		try {
			AttendenceDto attendenceDto2 = new AttendenceDto();
			Attendence attendence = attendenceDto2.convertToentity(attendenceDto);
			attendenceDao.saveAttendence(attendence);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

//	@Override
//	public List<AttendenceDtoV2> getdataBydate(String date) {
//		
//		
//		return null;
//	}
	
	
	

	@Override
	public ByteArrayInputStream getdataBydate(String dateserch) {
//		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			Date date = dateFormat.parse(dateserch);

			String format = dateFormat.format(date);
			Date dateFormats = dateFormat.parse(format);
			Date date2 = dateFormat.parse(format);
			List<Attendence> studentdatabyDate = attendenceDao.getbyDate(date2);

			List<AttendenceDtoV2> attendenceDtoList = new ArrayList<>();

			for (Attendence attendence : studentdatabyDate) {

				AttendenceDtoV2 attendenceDtoV2 = new AttendenceDtoV2();

				attendenceDtoV2.setName(attendence.getStudent().getName());
				if(attendence.getAttendence()==true)
				{
				attendenceDtoV2.setStatus("Present");
				}
				else
				{
					attendenceDtoV2.setStatus("Absent");
				}
				attendenceDtoV2.setDate(attendence.getDate());
				attendenceDtoList.add(attendenceDtoV2);
			}
//			ByteArrayInputStream datatoexcel = Helper.datatoexcel(attendenceDtoList);

//			return datatoexcel;
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public ByteArrayInputStream getDatatoDatereport(Date date, Date date1)  {
		
		try
		{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format1 = dateFormat.format(date);
		Date dateFormats = dateFormat.parse(format1);
		
		
		String format2 = dateFormat.format(date1);
		Date dateFormats1 = dateFormat.parse(format2);
		
		Map<String, Map<String, Boolean>> attendanceDetails = new HashMap<>();
		List<Attendence> getDataDateToDate = attendenceDao.getdatadatetoDate(dateFormats, dateFormats1);

		for (Attendence obj : getDataDateToDate) {
		    String studentName = obj.getStudent().getName();

		    // Check if the student name is already in the outer map
		    if (!attendanceDetails.containsKey(studentName)) {
		        // Create a new inner map for this student
		        Map<String, Boolean> addDetails = new HashMap<>();
		        attendanceDetails.put(studentName, addDetails);
		    }

		    Map<String, Boolean> innerMap = attendanceDetails.get(studentName);
		    String format = dateFormat.format(obj.getDate());
		    innerMap.put(format, obj.getAttendence());
		}
		
//		for(String name:attendanceDetails.keySet())
//		{
//			System.out.println(name);
//			Map<String, Boolean> map = attendanceDetails.get(name);
//			for(String x:map.keySet())
//			{
//				System.out.println(x);
//				System.out.println(map.get(x));
//			}
//			System.out.println("---------------------------------------------------------");
//		}
		
		
		List<LocalDate> datesList = calculateDate.getDatesList("MONTHLY");
		List<String> datesinString=new ArrayList<>();
		datesList.forEach(x -> {
//			String dateS = dateFormat.format(x);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dateS = x.format(formatter);
			datesinString.add(dateS);
			
		});
		int size = datesinString.size();
		String Header[]= new String[size+1];
		Header[0]="Name";
		
		
		for(int i=1;i<Header.length;i++)
		{
			 Header[i] = datesinString.get(i - 1);
		}

		
		ByteArrayInputStream datatoexcel = Helper.datatoexcel(Header,attendanceDetails);
		return datatoexcel;
		
		}catch (Exception e) {
			return null;
		}
		
		
	}
	
	
}
