package com.code.practice.sample.problem.number2;

public class Solution {

	public int[] twoSum(int[] nums, int target) {

		int[] out = new int[2];
		
		if(nums == null || nums.length <= 1)
			return null;
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if(i==j)
					continue;
				if(nums[i] + nums[j] == target) {
					out[0] = i;
					out[1] = j;
					return out;
				}
			}
		}
		
		return out;
    }
}
