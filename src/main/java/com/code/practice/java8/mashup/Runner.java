package com.code.practice.java8.mashup;

import java.util.Optional;

public class Runner {

	public static void main(String[] args) {
		
		Singleton s = Singleton.getInstance();
		
		System.out.println(s);
		
		Optional<Singleton> op = Optional.ofNullable(null);
		
		System.out.println(op.get());

		
		
		//ENUM
		EnumSingleton singleton = EnumSingleton.INSTANCE;

        System.out.println(singleton.getValue());

        singleton.setValue(2);
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;

        System.out.println(singleton2.getValue());
		
	}

}
