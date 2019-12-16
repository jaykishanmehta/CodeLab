package com.code.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface Sample {
	int x = 1;
	
	byte b = (byte) 1200;

	public static void main(String args[]) {
		System.out.println("Sum of x+y = " + x);
		System.out.println(b);
		
		A a = new A();
		a.sample();
		
		
		testMethod("1");
		testMethod(3);
	}

	public static void testMethod(String string) {
		System.out.println(string);
	}
	
	public static void testMethod(Object o) {
		System.out.println(o);
	}
	
}


class A {
	void sample() {
		System.out.println("Sample");
	}
}