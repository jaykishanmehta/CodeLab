package com.code.practice.sample.hackerrank.JavaLoopII;

import java.util.Scanner;

class Solution {
	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		String[] output = new String[t];
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();

			output[i] = "";
			int last = 0;
			for (int j = 0; j < n; j++) {
				last += Math.pow(2, j);
				output[i] += (a + (b * last)) + " ";
			}

		}

		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
		in.close();
	}
}
