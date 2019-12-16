package com.code.practice.sample.program;

/**
 * 
 * Problem <br/>
 * Write a function to find the longest common prefix string amongst an array of strings.<br/>
 * <br/>
 * Analysis <br/>  
 * To solve this problem, we need to find the two loop conditions. One is the length of the shortest string. The other is iteration over every element of the string array.
 * 
 * @author jaykishanm
 *
 */
public class LongestCommonPrefixGoogle {

	public static void main(String[] args) {

		System.out.println("----Start----");
		System.out.println(longestCommonPrefix(new String[] {"test", "tel", "tes"}));
		System.out.println(longestCommonPrefix(new String[] {"om", "ompr", "ompraka", "o"}));
		System.out.println("----End ----");
	}

	public static String longestCommonPrefix(String[] strs) {
		
	    if(strs==null || strs.length==0){
	        return "";
	    }
	 
	    if(strs.length==1) 
	        return strs[0];
	 
	    int minLen = strs.length+1;
	 
	    for(String str: strs){
	    	if(str == null)
	    		return null;
	    	
	        if(minLen > str.length()){
	            minLen = str.length();
	        }
	    }
	 
	    for(int i=0; i<minLen; i++){
	        for(int j=0; j<strs.length-1; j++){
	            String s1 = strs[j];
	            String s2 = strs[j+1];
	            //System.out.println("S1: " + s1 + " S2: " + s2);
	            if(s1.charAt(i)!=s2.charAt(i)){
	            	//System.out.println("s1.substring(0, i): " + s1.substring(0, i));
	                return s1.substring(0, i);
	            }
	        }
	    }
	 
	    return strs[0].substring(0, minLen);
	}
}
