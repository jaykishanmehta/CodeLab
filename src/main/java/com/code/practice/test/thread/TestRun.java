package com.code.practice.test.thread;

public class TestRun {
	public static void main(String[] args) {
		try {
			
			ThreadRunner runner = null;
			for (int i = 0; i < 5; i++) {
				runner = new ThreadRunner("i" + i);
				runner.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class ThreadRunner extends Thread {
		
		public ThreadRunner(String name) {
			super();
			Thread.currentThread().setName(name);
		}
		
		public void run() {
			WorkerClass newClass = null;
			for (int i = 0; i < 5; i++) {
				System.out.println("=====================> " + i + " " + Thread.currentThread().getName());
				/*newClass = NewClass.getInstance();
				newClass.execute(i+" " + Thread.currentThread().getName());*/
				WorkerClass.execute(i+" " + Thread.currentThread().getName());
			}
		}
	}
}

