package com.code.practice.sample.program.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class StringProblem2 {
	
	public static void main(String[] args) {
		
		StringBuilder builder = new StringBuilder();
		try {
			String fileName = "E:/testcase.txt";
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
			    //process the line
				builder.append(line);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(isValid(builder.toString()));
		//System.out.println(isValid("abcdefghhgfedecba"));
		
	}
	

    // Complete the isValid function below.
	static String isValid(String s) {
        //String isValid = "NO";

        if(s == null || s.length() == 0) {
            return "YES";
        }

        int temp = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< s.length(); i++) {
            temp = 1;
            if(map.containsKey(s.charAt(i))) {
                temp = map.get(s.charAt(i));
                temp++;
            }
            map.put(s.charAt(i),temp);
            
        }

        
        System.out.println(map);
        
        int minCount = s.length();
        int maxCount = 0;
        Map<Integer, Integer> map2 = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
        	temp = 0;
        	if(map2.containsKey(entry.getValue())) {
        		temp = map2.get(entry.getValue()) + 1;
        		map2.put(entry.getValue(), temp);
        	} else {
        		map2.put(entry.getValue(), 1);
        	}
        	
        	temp = entry.getValue();
        	if(minCount > temp) {
            	minCount = temp;
            }
            if(maxCount < temp) {
            	maxCount = temp;
            }
        }
        
        System.out.println("min: " + minCount + " max: " + maxCount);
        if(minCount == maxCount)
        	return "YES";
        if(map.size() == 1 || (map.size() == 2 && minCount == 1) ) {
            return "YES";
        }
        
        System.out.println(map2);
        if(map2.size() > 2)
        	return "NO";
        else {
        	if(map2.containsKey(new Integer(1))
        			&& map2.get(new Integer(1)) > 1 
        			&& map2.containsKey(new Integer(2)) 
        			&& map2.get(new Integer(2)) == 1) {
        		return "YES";
        	} else if(map2.containsKey(new Integer(1))
        			&& map2.get(new Integer(1)) == 1) {
        		return "YES";
        	} else {
        		if(maxCount - minCount == 1 && map2.get(maxCount) == 1) {
        			return "YES";
        		}
        	}
        }
        
        System.out.println("Work in progress");
        return "NO";
    
        /*for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if(entry.getValue() < minCount)
                minCount = entry.getValue();
        }


        System.out.println(s.length()/map.size());
        System.out.println(map.toString());

        int expectedFigit = s.length()/map.size();
        boolean isDirty = false;

        if(map.size() == 1 || (map.size() == 2 && minCount == 1) ) {
            return "YES";
        }

        if(s.length() % map.size() == 0 || s.length() % map.size() == 1 )
        	return "YES";
        
        if(s.length() % map.size() > 1)
        	return "NO";*/
        
        /*if(minCount == 1 && map.size() > 2) {
            expectedFigit = s.length()/(map.size()-1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue() + "/" + isDirty);
            if(entry.getValue() == expectedFigit) {
                continue;
            } else {
                if(!isDirty) {
                    isDirty = true;
                } else {
                    return "NO";
                }
            }
        }

        isValid = "YES";*/
    }

    //private static final Scanner scanner = new Scanner(System.in);

    /*public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }*/
}
