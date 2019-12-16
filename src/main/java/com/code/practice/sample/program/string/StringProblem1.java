package com.code.practice.sample.program.string;

import java.lang.reflect.Field;

public class StringProblem1 {
	public static void main(String[] args) {
		String str1 = "hello";

		String str2 = "world";

		String str3 = "helloworld";

		System.out.println(str1 + str2 == str3);// false

		final String str4 = "hello";

		final String str5 = "world";
		final String str6 = "helloworld";

		
		System.out.println(showInternalCharArrayHashCode(str6));
		System.out.println(showInternalCharArrayHashCode(str3));
		System.out.println(showInternalCharArrayHashCode(str4 + str5));
		System.out.println(showInternalCharArrayHashCode(str1 + str2));
		
		System.out.println(new String().intern());
		
		System.out.println(str4 + str5 == str3);// true
		System.out.println(str4 + str5 == "helloworld");// true
		System.out.println(str4 + str5 == str6);// true
		System.out.println(new String().intern());
	}
	
	
	private static int showInternalCharArrayHashCode(String s) {
		
		try {
			final Field value = String.class.getDeclaredField("value");
		    value.setAccessible(true);
		    return value.get(s).hashCode();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return -1;
	}
}

