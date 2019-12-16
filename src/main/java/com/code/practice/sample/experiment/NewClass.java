package com.code.practice.sample.experiment;

public class NewClass {
	private int bTest = 5;

	public int isbTest() {
		return bTest;
	}

	public void setbTest(int bTest) {
		this.bTest = bTest;
	}

	@Override
	public String toString() {
		return "NewClass [bTest=" + bTest + "] ";
	}

	public void process() {
		--bTest;
	}
	
}
