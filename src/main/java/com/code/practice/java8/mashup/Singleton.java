package com.code.practice.java8.mashup;

public final class Singleton {

	private static Singleton SINGLETON = null;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(SINGLETON == null) {
			synchronized (Singleton.class) {
				if(SINGLETON == null) {
					SINGLETON = new Singleton();
				}
			}
		}
		
		return SINGLETON;
	}
}
