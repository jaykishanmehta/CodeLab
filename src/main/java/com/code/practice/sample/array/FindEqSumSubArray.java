package com.code.practice.sample.array;

/**
 * 
 * <pre>
	Number of subarrays having sum in a given range
	
	Given an array arr[] of positive integers and a range (L, R). Find number of subarrays having sum in the range L to R.
	
	Examples:
	
	Input : arr[] = {1, 4, 6}, L = 3, R = 8
	Output : 3
	The subarrays are {1, 4}, {4}, {6}.
	
	Input : arr[] = {2, 3, 5, 8}, L = 4, R = 13
	Output : 6
	The subarrays are {2, 3}, {2, 3, 5}, {3, 5},
	{5}, {5, 8}, {8}.
	</pre>
 * 
 * 
 * @author jaykishanm
 *
 */
public class FindEqSumSubArray {

	public static void main(String[] args) {

		System.out.println("=======================Start====================");
		findEqSumSubArray();
		System.out.println("=======================End=====================");
	}

	private static void findEqSumSubArray() {
		int arr[] = {1,4,6};
		//int arr[] = {2,3,5,8};
		int L = 3;
		int R = 13;
	}

}
