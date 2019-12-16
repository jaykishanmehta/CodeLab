package com.code.practice.test.thread;

public class WorkerClass {

	private static WorkerClass singletonInstance = null;
	
	public static WorkerClass getInstance() {
		if(singletonInstance == null)
			singletonInstance = new WorkerClass();
		return singletonInstance;
	}
	
	public static synchronized void execute(String value) {
		System.out.println("==> " + value);
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
