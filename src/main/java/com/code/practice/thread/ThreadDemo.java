package com.code.practice.thread;

public class ThreadDemo {
	
	public static void main(String[] args) {
		System.out.println("Program Start");
		
		Runnable r = () -> System.out.println("test");
		
		Thread t = new Thread(r);
		
		t.start();
		t.run();
		
		System.out.println("Program Stop");
	}
}
