package com.java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class Java8DateTime {

	public static void main(String[] args) {


		LocalDate date = LocalDate.now(); // Static method

		System.out.println(date);
		
		LocalDate date2 = LocalDate.of(1986, 9, 22); // Static method

		System.out.println(date2);
		
		LocalDate date3 = LocalDate.of(1986, Month.SEPTEMBER, 22); // Static method

		System.out.println(date3);
		
		LocalTime t1 = LocalTime.now();
		System.out.println(t1);

		/*for ( String zoneId : ZoneId.getAvailableZoneIds() ) {
			System.out.println(zoneId);
		}*/
		
		LocalTime t2 = LocalTime.now(ZoneId.of("America/New_York"));
		System.out.println(t2); //02:27:54.438
		
		
		Instant instant = Instant.now();
		
		System.out.println(instant);  // Gives date and time in GMT (2018-03-09T07:26:39.529Z)
		
		
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);  // 2018-03-08T23:27:54.446
		
	}

}
