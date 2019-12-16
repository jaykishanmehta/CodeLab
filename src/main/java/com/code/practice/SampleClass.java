package com.code.practice;

import java.util.HashMap;
import java.util.Map;

public class SampleClass {
	
    public static void main(String[] args) {
    	
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("1", "A");
    	map.put(null, "C");
    	map.put("4", "D");
    	map.put("2", "B");
    	map.put("3", "D");
    	map.put("7", "O");
    	map.put("5", "H");
    	map.put("6", "D");
    	map.put("8", "G");
    	map.put("10", "D");
    	map.put("9", "D");
    	map.put("11", "F");
    	map.put("13", "D");
    	map.put("14", "Q");
    	map.put("12", "D");
    	
    	for (String key : map.keySet()) {
			System.out.println("key: " + key + " value: " + map.get(key));
		}
    	
    	
    	Map<Integer, String> map2 = new HashMap<Integer, String>();
    	map2.put(1, "A");
    	map2.put(null, "C");
    	map2.put(4, "D");
    	map2.put(2, "B");
    	map2.put(3, "D");
    	map2.put(6, "D");
    	map2.put(5, "B");
    	map2.put(8, "D");
    	map2.put(10, "D");
    	map2.put(9, "B");
    	map2.put(7, "D");
    	map2.put(13, "D");
    	map2.put(12, "B");
    	map2.put(11, "D");
    	map2.put(14, "D");
    	
    	for (Integer key : map2.keySet()) {
			System.out.println("key: " + key + " value: " + map2.get(key));
		}
    	
	}
}
