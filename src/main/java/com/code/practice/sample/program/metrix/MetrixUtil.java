package com.code.practice.sample.program.metrix;

public class MetrixUtil {
	public static void print2DMetrix(int[][] met) {
		for (int i = 0; i < met.length; i++) {
			for (int j = 0; j < met[i].length; j++) {
				System.out.print(met[i][j] + " ");
			}
			System.out.println();
		}
	}
}
