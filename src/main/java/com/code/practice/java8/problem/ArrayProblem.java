package com.code.practice.java8.problem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class ArrayProblem {

	public static void main(String[] args) {
		
		Integer[] arr = new Integer[] {10,3,4,1, 11,7,3,8,2,10, 15, 10, 11};
		
		System.out.println(Arrays.toString(arr));
		System.out.println("Highest: " + findSecondHighest(arr));
		
		
		System.out.println("Second Highest: " + findSecondHighestUsingReduce(arr));

	}

	private static int findSecondHighestUsingReduce(Integer[] arr) {
		
		  List<Integer> integers = Arrays.asList(arr);
		  
		  SecondHighest secondHighest= integers.stream().reduce(new SecondHighest(Integer.MIN_VALUE, Integer.MIN_VALUE), SecondHighest::accumulate, SecondHighest::combine);
		  
		  //SecondHighest ss = new SecondHighest(Integer.MIN_VALUE, Integer.MIN_VALUE);
		  
		  //SecondHighest secondHighest11= integers.stream().reduce(ss, (SecondHighest t, Integer u) -> t.accumulate(i), SecondHighest::combine);
		  //SecondHighest java.util.function.BiFunction.apply(SecondHighest t, Integer u)
		  
		  //IntStream.rangeClosed(0, 100).forEach(System.out::println);
		  //DoubleStream.generate(Math::random).limit(10).forEach(System.out::println);
		  
		  System.out.println(secondHighest);
		  
		  return secondHighest.getSecondHighest();
		
	}

	private static int findSecondHighest(Integer[] arr) {
		
		int highest = Integer.MIN_VALUE;
		int lastHighest = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(highest < arr[i]) {
				
				if (lastHighest < highest) {
					lastHighest = highest;
				}
				 
				highest = arr[i];
			} else {
				if(arr[i] > lastHighest)
					lastHighest = arr[i];
			}
		}
	
		System.out.println("Second Highest:  " + lastHighest);
		return highest;
	}

}
