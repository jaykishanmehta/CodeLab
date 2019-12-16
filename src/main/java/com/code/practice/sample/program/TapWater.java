package com.code.practice.sample.program;

import java.io.IOException;

/**
 * https://www.geeksforgeeks.org/trapping-rain-water/
 * 
 * @author jaykishanm
 */
public class TapWater {

    // Complete the climbingLeaderboard function below.
    static int tapWater(int[] scores) {
    	int out = 0;

    	int i = 0;
    	int start = -1;
    	int end = -1;
    	int tempSum = 0;
    	while (i < scores.length) {
    		if(start == -1 && i+1 < scores.length && scores[i] > scores[i+1]) {
    			start = i;
    		} else if(start > -1 && i+1 < scores.length && scores[i] < scores[i+1]) {
    			tempSum += scores[i];
    			end = i+1;
    		} else if(start > -1) {
    			tempSum += scores[i];
    		}
    		i++;
    		
    		if(start > -1 && end > -1 && start < end) {
    			
    			int minIndex = -1;
    			if(scores[start] > scores[end]) {
    				minIndex = end;
    			} else {
    				minIndex = start;
    			}

    			out += (end - start - 1) * scores[minIndex] - tempSum;
    			
    			tempSum = 0;
    			start = -1;
    			end = -1;
    		}
    	}
    	
    	
        return out;

    }

    public static void main(String[] args) throws IOException {
    	//System.out.println(tapWater(new int[] {5,1,5}));
    	System.out.println(tapWater(new int[] {1,0,2,0,3,0,2,0,1}));
    	//System.out.println(tapWater(new int[] {4,0,3,1,4,0,5}));
    	//System.out.println(tapWater(new int[] {1,0,3}));
    }
}
