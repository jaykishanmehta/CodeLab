package com.code.practice.sample.program;

import java.util.Iterator;
import java.util.Stack;

/**
 * 
 * path = "/home/", => "/home" <br/>
 * path = "/a/./b/../../c/", => "/c" <br/>
 * path = "/../", => "/" <br/>
 * path = "/home//foo/", => "/home/foo" <br/><br/>
 * 
 * @author jaykishanm
 *
 */
public class SimplifyPath {

	public static void main(String[] args) {
		System.out.println("----Start----");
		System.out.println("Input: /home/ , Output: " + getSimplifyPath("/home/"));
		System.out.println("Input: // , Output: " + getSimplifyPath("//"));
		System.out.println("Input: /a/./b/../../c/ , Output: " + getSimplifyPath("/a/./b/../../c/"));
		System.out.println("Input: /../ , Output: " + getSimplifyPath("/../"));
		System.out.println("Input: /home//foo/ , Output: " + getSimplifyPath("/home//foo/"));
		System.out.println("Input: /a/./b/../.. , Output: " + getSimplifyPath("/a/./b/../.."));
		System.out.println("Input: /a/./b/.. , Output: " + getSimplifyPath("/a/./b/.."));
		System.out.println("Input: /a/./b , Output: " + getSimplifyPath("/a/./b"));
		System.out.println("----End ----");
	}

	public static String getSimplifyPath(String inputPath) {
		
		if(inputPath == null || inputPath.trim().isEmpty())
			return "";
		
		inputPath = inputPath.trim().replace("//", "/");
		if(inputPath.length() == 1) {
			if(inputPath.equals("/"))
				return "/";
			else 
				return "error";
		}
		
		if(inputPath.startsWith("/")) {
			String[] pathArray = inputPath.split("/");
			Stack<String> outPath = new Stack<>();
			for (int i = 0; i < pathArray.length; i++) {
				String curPath = pathArray[i];
				//System.out.println(outPath + " ==>" + curPath + "<");
				if(curPath.equals(".") || curPath.isEmpty())
					continue;
				else if(curPath.equals("..")) {
					if(outPath.size() == 0)
						continue;
					else
						outPath.pop();
				} else {
					outPath.push(curPath);
				}
			}
			
			StringBuffer buffer = new StringBuffer();
			if(outPath.isEmpty()) {
				return "/";
			}
			for (Iterator iterator = outPath.iterator(); iterator.hasNext();) {
				buffer.append("/" + iterator.next());
			}
			inputPath = buffer.toString();
			//System.out.println(buffer);
		} else {
			return "error";
		}
		
		
		return inputPath;
	}
}
