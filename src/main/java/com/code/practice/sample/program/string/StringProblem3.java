package com.code.practice.sample.program.string;

import java.util.Scanner;

class StringProblem3{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
			System.out.println(verifyString(input));
		}
		
		/*({}[])
		(({()})))
		({(){}()})()({(){}()})(){()}
		{}()))(()()({}}{}
		}}}}
		))))
		{{{
		(((
		[]{}(){()}((())){{{}}}{()()}{{}{}}
		[[]][][]
		}{*/
		
		
		
	}
    public static boolean verifyString(String input) {

        if(input == null || input.isEmpty())
            return true;
        if(input.length() % 2 == 1)
            return false;

        char[] stack = new char[input.length()];
        int stackIndex = -1;
        //stack[stackIndex] = input.charAt(0);
        for(int i=0; i< input.length(); i++) {
            char temp = input.charAt(i);
            if(stackIndex == -1 && checkPositive(temp)) {
                stackIndex = 0;
                stack[stackIndex] = temp;    //Push
            } else if(stackIndex > -1 && stack[stackIndex] == fetchRelevant(temp)) {
                stackIndex--;       //Pop
            } else if(checkPositive(temp)){
                stackIndex++;       //Push
                stack[stackIndex] = temp;    //Push
            } else {
                return false;
            }
        }

        //System.out.println("stackIndex: " + stackIndex);

        if(stackIndex == -1)
            return true;
        else   
            return false;
    }
    
    public static char fetchRelevant(char sign) {
    	char out = 0;
        switch(sign){
            case '{': return '}';
            case '}': return '{';
            case '(': return ')';
            case ')': return '(';
            case '[': return ']';
            case ']': return '[';
        }
        return out;
    }
    
    public static boolean checkPositive(char sign) {
        boolean is = false;
        if(sign == '{' || sign == '(' || sign == '[')
            is = true;

        return is;
    }
}



