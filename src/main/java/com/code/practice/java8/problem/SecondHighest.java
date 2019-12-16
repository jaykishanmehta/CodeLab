package com.code.practice.java8.problem;

public class SecondHighest {
	private Integer highest;
	private Integer secondHighest;
	
	public SecondHighest(int highest, int secondHighest) {
		this.highest = highest;
		this.secondHighest = secondHighest;
	}
	
	public SecondHighest accumulate(Integer i) {
		
		//System.out.println(i + " " + j);
		
		if(highest < i) {
			
			if (secondHighest < highest) {
				secondHighest = highest;
			}
			 
			highest = i;
		} else {
			if(i > secondHighest)
				secondHighest = i;
		}
		return this;
	}
	
	public SecondHighest combine(SecondHighest secondHighest) {
		return secondHighest;
	}
	
	public Integer getHighest() {
		return highest;
	}
	public Integer getSecondHighest() {
		return secondHighest;
	}

	@Override
	public String toString() {
		return "SecondHighest [highest=" + highest + ", secondHighest=" + secondHighest + "]";
	}
}
