package com.code.practice.sample.sorting.selection;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[] {4,1,3,2};
		
		System.out.println("Swap:" + selectionSort(arr));

	}

	private static int selectionSort(int[] arr) {
		int swap = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			
			System.out.println(Arrays.toString(arr));
			for (int j = 0; j < arr.length - i; j++) {
				if(arr[j] < arr[min])
					min = j;
			}
			
			System.out.println("Max: " + min + " pos: " + i);
			if(min != i) {
				swap(arr, min, i);
				swap++;
			}
		}
		
		return swap;
	}

	private static void swap(int[] arr, int max, int i) {
		int temp = 0;
		temp = arr[max];
		arr[max] = arr[i];
		arr[i] = temp;
	}

}
