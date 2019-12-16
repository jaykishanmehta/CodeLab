package com.code.practice.sample.program.core;

/**
 * 1. Static block > Initialize Block > Constructor <br>
 * 2. Uncomment below code and see error message for static method
 * 
 * @author jaykishanm
 *
 */
public class ProgramRunner {

	String abc = "test";
	public static void main(String[] args) {
		SampleJavaObject javaObject = new SampleJavaObject();
		SampleJavaObject javaObject2 = new SampleJavaObject();
		
		//TODO: Uncomment below to see error message while accessing class variable in static method
		//System.out.println(this.abc);
		//System.out.println(abc);
	}

}
