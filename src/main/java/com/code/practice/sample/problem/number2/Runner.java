package com.code.practice.sample.problem.number2;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/two-sum/description/
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 * 
 * 
 * @author jaykishanm
 *
 */
public class Runner {
	public static void main(String[] args) {
	
		//int[] test = {2, 7, 11, 15};
		//int target = 9;
		
		//int[] test = {3,2,4};
		//int target = 6;
		
		int[] test = {0,4,3,0};
		int target = 0;
		
		System.out.println("Input: " + Arrays.toString(test));
		System.out.println("Target: " + target);
		
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.twoSum(test, target)));
	}
}
