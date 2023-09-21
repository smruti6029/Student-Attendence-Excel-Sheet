package com.sa.controller;



import org.springframework.http.MediaType;
import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sa.dto.AttendenceDto;
import com.sa.dto.AttendenceDtoV2;
import com.sa.entity.Attendence;
import com.sa.service.AttendenceService;

@RestController
@RequestMapping("/v1/attendence/")
public class AttendenceController {
	
	
	@Autowired
	private AttendenceService attendenceService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addAttendence(@RequestBody AttendenceDto attendenceDto)
	{
		System.out.println(attendenceDto);
		Integer addAttendence = attendenceService.addAttendence(attendenceDto);
		if(addAttendence>0)
		{
			return ResponseEntity.ok("Attendence Add succesfully");
		}
		
		
		return ResponseEntity.badRequest().body("try Agin");
	}
	
	
	@GetMapping("/date/{date}")
	public ResponseEntity<?> getstudentdatabyDate(@PathVariable("date") String date)
	{
		
		
		String filename="product.xlsx";
		ByteArrayInputStream actualData = attendenceService.getdataBydate(date);
		InputStreamResource file = new InputStreamResource(actualData);
		ResponseEntity<Resource> body = ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename"+filename).contentType(MediaType
				.parseMediaType("application/vnd.ms-excel")).body(file);
		
		
		return body;
	}

	
	
	
	@GetMapping("/get")
	public ResponseEntity<?> getdataDatetodate() throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormat.parse("2023-09-10");
        Date date2 = dateFormat.parse("2023-09-19");
        ByteArrayInputStream actualData = attendenceService.getDatatoDatereport(date1, date2);
        String filename="studentattendence.xlsx";
		InputStreamResource file = new InputStreamResource(actualData);
		ResponseEntity<Resource> body = ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename"+filename).contentType(MediaType
				.parseMediaType("application/vnd.ms-excel")).body(file);
		
		
		return body;
        

	}
	}
//		WeekFields weekFields = WeekFields.of(Locale.getDefault()).withFirstDayOfWeek(DayOfWeek.MONDAY); 
//		
//		
//		
//		
////		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////
////        try {
////            Date date = dateFormat.parse("2023-09-20");
////
////            Calendar calendar = Calendar.getInstance();
////            calendar.setTime(date);
////            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
////
////            Date startDate = calendar.getTime();
////
////            List<Date> weekDates = new ArrayList<>();
////            for (int i = 0; i < 7; i++) {
////                weekDates.add(startDate);
////                calendar.add(Calendar.DAY_OF_MONTH, 1);
////                startDate = calendar.getTime();
////            }
////
////            for (Date weekDate : weekDates) {
////                System.out.println(dateFormat.format(weekDate));
////            }
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////		return null;
//	}
//}
//   
//	
//	
////	public List<Date> getWeekDates(Date date) {
////		List<Date> datesList = new ArrayList<>();
////		Calendar calender = Calendar.getInstance();
////		calender.setTime(date);
////		calender.add(Calendar.DAY_OF_YEAR, -6);
////
////		for (int i = 0; i < 7; i++) {
////			Date dateObj = calender.getTime();
////			datesList.add(dateObj);
////			calender.add(Calendar.DAY_OF_YEAR, 1);
////		}
////		return datesList;
////	}
//	
////	}


