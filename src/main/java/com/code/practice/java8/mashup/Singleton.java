package com.code.practice.java8.mashup;

/**
 * KNOWLEDGE:: Singleton class with lazy initialization and double check for thread safety. 
 * 
 * @author jaykishan.mehta
 */
public final class Singleton {

	private static Singleton SINGLETON = null;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(SINGLETON == null) {		//CHECK1
			synchronized (Singleton.class) {
				if(SINGLETON == null) {		//CHECK2
					SINGLETON = new Singleton();
				}
			}
		}
		
		return SINGLETON;
	}
}
