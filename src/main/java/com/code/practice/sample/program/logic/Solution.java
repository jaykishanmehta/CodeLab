package com.code.practice.sample.program.logic;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
    	int[] ans = new int[grades.length];
    	
    	for (int i = 0; i < grades.length; i++) {
			float grade = grades[i];
			
			if(grade < 38) {
				ans[i] = Math.round(grade);
			} else {
				float f = (grade/5) % 1;
				if(f < 0.50)
					ans[i] = Math.round(grade);
				else {
					grade = (float) (grade + Math.round(((1 - f)*5)));
					ans[i] = Math.round(grade);
				}
			}
		}
    	
    	
    	return ans;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] grades = new int[] {73,65,48,42};

        int[] result = gradingStudents(grades);
        
        System.out.println(Arrays.toString(result));

    }
}
