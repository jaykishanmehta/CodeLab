package com.code.practice.sample.test;

public class Runner {

	public static void main(String[] args) {
		
		Employee employee1 = new Employee(1, "A");
		Employee employee2 = new Employee(1, "A");
		
		System.out.println("employee1 == employee2: " + (employee1 == employee2));
		System.out.println("employee1.equals(employee2): " + (employee1.equals(employee2)));
		System.out.println("employee1.getClass(): " + employee1.getClass());
		System.out.println("employee1.getName(): " + employee1.getName());
		
	}

}
