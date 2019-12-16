package com.code.practice.sample.program.string;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

    // Complete the anagram function below.
    static int anagram(String s) {
    	
    	int anagram = 0;

    	if(s == null || s.length() % 2 == 1)
    		anagram = -1;
    	else {
    		String a = s.substring(0, s.length()/2);
    		String b = s.substring(s.length()/2);
    		System.out.println("a: " + a);
    		System.out.println("b: " + b);
    		
    		if(a.equals(b))
    			anagram = 0;
    		else {
    			Map<Character, Integer> map = new HashMap<>();
    	        
    	        int anagramCount = 0;
    	        
    	        for (int i = 0; i < a.length(); i++) {
    	            char key = a.charAt(i);
    	            int count = 0;
    	            if(map.containsKey(key)) {
    	                count = map.get(key);
    	            }
    	            count++;
    	            map.put(key, count);
    	        }
    	        //System.out.println(map);        
    	        for (int i = 0; i < b.length(); i++) {
    	            char key = b.charAt(i);
    	            int count = 0;
    	            if(map.containsKey(key)) {
    	                count = map.get(key);
    	                count--;
    	                map.put(key, count);
    	            } else {
    	                anagramCount++;
    	            }
    	            if(count == 0) {
    	                map.remove(key);
    	            }
    	        }
    	        //System.out.println(map);
    	        
    	        /*for (int val : map.values()) {
    	            anagramCount+=val;
    	        }*/
    	        
    	        anagram = anagramCount;
    		}
    	}
    	

    	return anagram;
    }

    public static void main(String[] args) throws IOException {

    	String s= "xaxbbbxx";
    	
    	System.out.println(anagram(s));
    }
}
