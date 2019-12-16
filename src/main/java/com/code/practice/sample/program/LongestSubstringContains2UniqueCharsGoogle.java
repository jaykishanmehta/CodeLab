package com.code.practice.sample.program;

import java.util.HashMap;

/**
 * 
 * Given a string, find the longest substring that contains only two unique characters. For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb". <br/><br/>
 * Longest Substring Which Contains 2 Unique Characters <br/><br/>
 * In this solution, a hashmap is used to track the unique elements in the map. When a third character is added to the map, the left pointer needs to move right.<br/>
 * 
 * @author jaykishanm
 *
 */
public class LongestSubstringContains2UniqueCharsGoogle {

	public static void main(String[] args) {

		System.out.println("----Start----");
		System.out.println(lengthOfLongestSubstringTwoDistinct("cadbdbacc"));
		System.out.println("----End ----");
	}

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			if (map.size() > 2) {
				max = Math.max(max, i - start);
				while (map.size() > 2) {
					char t = s.charAt(start);
					int count = map.get(t);
					if (count > 1) {
						map.put(t, count - 1);
					} else {
						map.remove(t);
					}
					start++;
				}
			}
		}
		max = Math.max(max, s.length() - start);
		return max;
	}
}
