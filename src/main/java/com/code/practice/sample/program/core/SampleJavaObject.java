package com.code.practice.sample.program.core;

public class SampleJavaObject {
	
	static {
		System.out.println("static block");
	}
	
	{
		System.out.println("initialize block");
	}
	
	//final public SampleJavaObject() {		//TODO: Constructor can't be final!!
	public SampleJavaObject() {
		System.out.println("constructor");
	}

}
