package com.app.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertDateUtil {
	
		//String -> LocalDate
		public static LocalDate convertStringToLocalDateTime(String str) {
			//240601
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMdd");
			LocalDate ld = LocalDate.parse(str, dtf);
			return ld;
		}
}
