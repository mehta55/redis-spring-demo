package com.nagarro.redisspringdemo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@Configurable
@SpringBootApplication
public class RedisSpringDemoApplication {
	
	private  final DateFormat INDEX_NAME_FORMATTER = new SimpleDateFormat("dd-MM-yyyy_HH-mm");


	public static void main(String[] args) throws Exception {
		SpringApplication.run(RedisSpringDemoApplication.class, args);

//		check1();
//		System.out.println(format(LocalDateTime.now()));

//		System.out.println(differenceInDates(convertStringToLocalDateTime("21-06-1997"),
//				convertStringToLocalDateTime("19-06-1997")));
	
		System.out.println(format(LocalDateTime.now()));
	}

	private static void check1() {
		LocalDate date = LocalDate.now(ZoneId.of("America/New_York"));
		System.out.println(format(date));

	}

	private static void check() throws ParseException {
		LocalDateTime date = LocalDateTime.now(ZoneId.of("America/New_York"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateFormat.parse(date.toString()));
	}

	private static String format(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm");
		return formatter.format(date);
	}

	private static String format(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
		return formatter.format(date);
	}

	public static LocalDateTime convertStringToLocalDateTime(String dateTime) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(dateTime, dateFormat).atStartOfDay();
	}

	public static long differenceInDates(LocalDateTime dateCurrent, LocalDateTime dateFuture) {
		return ChronoUnit.DAYS.between(dateCurrent, dateFuture);
	}

}
