package com.code.practice.sample.problem.number3;
import java.io.IOException;

/**
 * https://www.hackerrank.com/challenges/kangaroo/problem 
 * @author jaykishanm
 */
public class Solution {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {

    	System.out.println("x1: " + x1 + " x2: " + x2);
        float y = (float)(x1 - x2)/ (float)(v2 - v1); 
        if(y > 0 && y == Math.round(y))
        	return "YES";
        
        return "NO";

    }

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = "4523 8092 9419 8076".split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);
        
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
