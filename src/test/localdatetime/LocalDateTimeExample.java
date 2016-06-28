package test.localdatetime;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateTimeExample {

	public static void main(String[] args) {

		// the current date
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		// 2014-02-10
		LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);
		System.out.println(tenthFeb2014);
		// months values start at 1 (2014-08-01)
		LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);
		System.out.println(firstAug2014);
		// the 65th day of 2010 (2010-03-06)
		LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);
		System.out.println(sixtyFifthDayOf2010);



	}

}
