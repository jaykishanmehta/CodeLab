package com.code.practice.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class Tester {

	public static void main(String[] args) {
		
		List<Integer> weights = Arrays.asList(3,2,4);
		
		IntFunction<Apple> appleInventor = i-> new Apple(i);
		
		//Factory Pattern!
		Map<String, Supplier<Apple>> appleMap = new HashMap<>();
		appleMap.put("orange", () -> new Apple("orange"));
		appleMap.put("red", () -> new Apple("red"));
		
		List<Apple> apples = new ArrayList<>();
		for (Integer integer : weights) {
			apples.add(appleInventor.apply(integer));
		}

		System.out.println(apples);

		Comparator<Apple> appleComparator = Comparator.comparing(Apple::getWeight);
		Comparator<Apple> appleComparatorReverse = Comparator.comparing(Apple::getWeight).reversed();
		
		apples.sort(appleComparator);
		System.out.println(apples);
		Apple a = null;
		
		assert a!= null;
		
		System.out.println(a);
		
		apples.sort(appleComparatorReverse);
		System.out.println(apples);
		
		System.out.println(apples instanceof Serializable);
		System.out.println(apples.get(0) instanceof Serializable);
		
		Apple redApple = appleMap.get("red").get();
		System.out.println(redApple);
		
		
	}
	
}
