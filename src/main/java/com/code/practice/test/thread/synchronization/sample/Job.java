package com.code.practice.test.thread.synchronization.sample;

public class Job extends Thread {

	private boolean shutdown = false;
	
	@Override
	public void run() {
		super.run();
		
		while(!shutdown) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void shutdown() {
		shutdown = true;
	}
}
