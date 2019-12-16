package com.code.practice.sample.program.staticBlock;

import java.util.Calendar;
import java.util.Scanner;

public class Solution {

    static int B, H;
    static boolean flag;
    static {
        Scanner scan = new Scanner(System.in);
        B = scan.nextInt();
        H = scan.nextInt();

        if(B <= 0 || H <= 0) {
            flag = false;
            try {
				throw new Exception("Breadth and height must be positive");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
        } else {
            flag = true;
        }
    }

public static void main(String[] args){
	
	Calendar calendar = Calendar.getInstance();
	calendar.set(0, 0, 0);
	//calendar.;
	
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

