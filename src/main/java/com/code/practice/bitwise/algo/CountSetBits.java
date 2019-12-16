package com.code.practice.bitwise.algo;

import java.util.Arrays;

public class CountSetBits {

	public static void main(String[] args) {
		System.out.println("Output: " + countSetBits(5));
	}
	
	static int countSetBits(int n) 
	{ 
	  
	    int cnt = 0; 
	  
	    int[] setBits = new int[n+1];
	  
	    // 0 has no set bit 
	    setBits[0] = 0; 
	  
	    // 1 has a single set bit 
	    setBits[1] = 1; 
	  
	    // For the rest of the elements 
	    for (int i = 2; i <= n; i++) { 
	  
	        // If current element i is even then 
	        // it has set bits equal to the count 
	        // of the set bits in i / 2 
	        if (i % 2 == 0) { 
	            setBits[i] = setBits[i / 2]; 
	        } 
	  
	        // Else it has set bits equal to one 
	        // more than the previous element 
	        else { 
	            setBits[i] = setBits[i - 1] + 1; 
	        }
	        
	        System.out.println(i + " == " + Arrays.toString(setBits));
	        
	    } 
	  
	    // Sum all the set bits 
	    for (int i = 0; i <= n; i++) { 
	        cnt = cnt + setBits[i]; 
	    } 
	  
	    return cnt; 
	} 

}
