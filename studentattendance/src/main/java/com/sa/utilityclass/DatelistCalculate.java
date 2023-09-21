package com.sa.utilityclass;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class DatelistCalculate {
	
	
	public List<LocalDate> getDatesList(String pattern) {
		if (pattern.equalsIgnoreCase("WEEKLY")) {
			LocalDate start = LocalDate.now();
			while (start.getDayOfWeek() != DayOfWeek.MONDAY) {
				start = start.minusDays(1);
			}
			LocalDate end = LocalDate.now();
			while (end.getDayOfWeek() != DayOfWeek.SUNDAY) {
				end = end.plusDays(1);
			}
			System.out.println(start);
			System.out.println(end);
			List<LocalDate> listOfDates = dummyService.getAllDatesList(start, end);
			return listOfDates;
		} else if (pattern.equalsIgnoreCase("MONTHLY")) {
			LocalDate monthBegin = LocalDate.now().withDayOfMonth(1);
			LocalDate monthEnd = LocalDate.now().plusMonths(1).withDayOfMonth(1).minusDays(1);
			System.out.println(monthBegin);
			System.out.println(monthEnd);
			List<LocalDate> listOfDates = dummyService.getAllDatesList(monthBegin, monthEnd);
			return listOfDates;
//		} else {
////			List<LocalDate> listOfDates = dummyService.getAllDatesList(start,end);
//			return listOfDates;
		}
		return null;
	}

}
