package com.code.practice.sample.program;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FindAnagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
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
    	System.out.println(map);    	
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
    	System.out.println(map);
    	
    	for (int val : map.values()) {
    		anagramCount+=val;
		}
    	
    	
    	return anagramCount;
    }

    public static void main(String[] args) throws IOException {

        /*String a = "abc";
        String b = "bcd";*/
    	String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        System.out.println(makeAnagram(a, b));
    }
}
