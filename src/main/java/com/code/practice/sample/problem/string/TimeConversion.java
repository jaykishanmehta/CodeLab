package com.code.practice.sample.problem.string;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TimeConversion {

	String s = "ABCDEFGHIJK";
	
	public static void main(String[] args) {
		
		
		IntStream.iterate(1, i -> {
			String s = "%" + (6-i) + "s";
			System.out.print(String.format(s, "_"));
			return i+1;
		}).limit(5).forEach(System.out::println);
		
		Stream.iterate("", s -> {
			
			;
			return s+"A";
		}).limit(5).forEach(System.out::println);
		
		System.out.println(timeConversion("07:05:45PM"));
		System.out.println(timeConversion("12:00:00PM"));
		System.out.println(timeConversion("12:05:39AM"));
	}
	
	static String timeConversion(String s) {

		if (s == null || s.isEmpty())
			return "";
		else
			s = s.trim();

		if(s.equals("12:00:00AM"))
			return "00:00:00";
		if(s.equals("12:00:00PM"))
			return "12:00:00";
		
		
		StringBuilder builder = new StringBuilder(10);
		
		String median = s.substring(8);
		int settlementHours = 0; 
		//System.out.println("Median: " + median);
		if(median.equals("PM"))
			settlementHours = 12;
		
		String hr = s.substring(0, 2);
		int newHr = Integer.parseInt(hr) + settlementHours;
		//System.out.println("newHr" + newHr);
		if(newHr == 24 || (median.equals("AM") && newHr == 12 )) {
			builder.append("00");			
		} else {
			builder.append(String.format("%2d", newHr));
		}
		builder.append(s.substring(2, 8));
		
		return builder.toString();
		
	}

}
