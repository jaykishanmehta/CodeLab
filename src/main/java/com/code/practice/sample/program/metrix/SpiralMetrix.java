package com.code.practice.sample.program.metrix;

import java.util.Arrays;

public class SpiralMetrix {

	public static void main(String[] args) {

		int[][] a = {
			      {1, 2, 3}, 
			      {4, 5, 6}, 
			      {7, 8, 9} 
			};
		
		int[][] b = {
			      {1, 2, 3, 4}, 
			      {5, 6, 7, 8}, 
			      {9, 10, 11, 12},
			      {13, 14, 15, 16}
			};
		
		int[][] c = {
			      {1, 2, 3, 4, 7}, 
			      {5, 6, 7, 8, 7}, 
			      {9, 10, 11, 12, 7},
			      {13, 14, 15, 16, 7},
			      {9, 10, 11, 12, 7}
			};
		
		System.out.println("----------Start---------");
		MetrixUtil.print2DMetrix(c);
		System.out.println(Arrays.toString(getSpiralMetrix(c)));
		System.out.println("----------End---------");
		
	}

	private static int[] getSpiralMetrix(int[][] a) {
		int[] outSprial = {};
		
		if(a.length == 0)
			return outSprial;
		
		if(a.length == 1)
			return a[0];
		
		if(a.length >= 2) {
			
			int curLength = a.length;
			outSprial = new int[a.length * a.length];
			int outSprialIndex = 0;
			int startingIndex = 0;
			while(curLength > 0) {
				
				int x= startingIndex;
				int y= startingIndex;
				
			/*	if(a.length == curLength) {
					x=0;
					y=0;
				} else {
					x= a.length - (a.length - curLength);
					y= a.length - (a.length - curLength);					
				}*/
				
				if(curLength == 1) {
					outSprial[outSprialIndex++] = a[x][y];
				} else {
					for (int i = 0; i < (curLength*4 - 4); i++) {
						//System.out.println("x: " + x + " y: " + y);
						
						outSprial[outSprialIndex++] = a[x][y];
						
						if(i < curLength-1)
							y++;
						if(i >= curLength-1 && i < (2*curLength - 2))
							x++;
						if(i >= (2*curLength - 2) && i < (3*curLength - 3))
							y--;
						if(i >= (3*curLength - 3) && i < (curLength*4 - 4))
							x--;
						
						//System.out.println(Arrays.toString(outSprial));
					}
				}
				
				curLength = curLength-2;
				startingIndex++;
			}
			
		}
		
		return outSprial;
	}

}
