package com.code.practice.sample.program;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * How to sort hashmap key-values by their values
 * 
 * @author jaykishan.mehta
 *
 */
public class SortMapByValue {

	public static void main(String[] args) {
		
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		hashMap.put(2, 15);
		hashMap.put(1, 17);
		hashMap.put(4, 12);
		hashMap.put(6, 13);
		hashMap.put(7, 14);
		
		System.out.println(hashMap);
		
		//Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();

		List<Map.Entry<Integer, Integer>> entries = 
	               new LinkedList<Map.Entry<Integer, Integer>>(hashMap.entrySet()); 
		
		Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		
		System.out.println(entries);
		
	}

}
