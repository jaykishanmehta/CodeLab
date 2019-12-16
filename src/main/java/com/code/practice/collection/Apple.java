package com.code.practice.collection;

public class Apple {

	public Apple(int weight) {
		super();
		this.weight = weight;
	}
	
	public Apple(String color) {
		super();
		this.color = color;
	}

	private String color;
	private Integer weight;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}
	
}
