package com.sa.utilityclass;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class dummyService {
	
	
	

	public static List<LocalDate> getAllDatesList(LocalDate start, LocalDate end) {

		long numOfDays = ChronoUnit.DAYS.between(start, end)+1;
		List<LocalDate> listOfDates = Stream.iterate(start, date -> date.plusDays(1))
			 	.limit(numOfDays)
			 	.collect(Collectors.toList());

		return listOfDates;
	}

}
