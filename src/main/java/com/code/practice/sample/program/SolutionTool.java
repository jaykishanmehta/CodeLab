package com.code.practice.sample.program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionTool {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> list = new ArrayList<>();
        
        
        Map<Integer, Integer> bucket = new HashMap<>();
        Map<Integer, Integer> counter = new HashMap<>();
        
        int count = 0;
        int countOfCount = 0;
        int tempcount = 0;
        for (List<Integer> integers: queries) {
        	
            count = 0;
            countOfCount = 0;
            int val = integers.get(1);
            if(integers.get(0) == 1) {
                if(bucket.containsKey(val)) {
                    count = bucket.get(val);
                    
                    int temp = 0; 
                    if(counter.containsKey(count)) {
                        temp = counter.get(count);
                    }
                    if(temp > 0) {
                        counter.put(count, --temp);
                    }
                }
                bucket.put(val, ++count);
                
                if(counter.containsKey(count)) {
                    countOfCount = counter.get(count);
                }
                counter.put(count, ++countOfCount);
            } else if(integers.get(0) == 2) {
                if(bucket.containsKey(val)) {
                    count = bucket.get(val);
                    bucket.put(val, count - 1);
                    if(counter.containsKey(count)) {
                    	countOfCount = counter.get(count);
                        counter.put(count, --countOfCount);
                        int temp = 0;
                        if(countOfCount > 0) {
                            if(counter.containsKey(countOfCount)) {
                                temp = counter.get(countOfCount);                        
                            }
                            counter.put(countOfCount, ++temp);                        
                        }                    	
                    }
                }
            } else if(integers.get(0) == 3) {
                if(counter.containsKey(val) && counter.get(val) >= 1)
                    list.add(1);
                else
                    list.add(0);
            }
            
            /*if(tempcount > 110) {
        		break;
        	}
        	tempcount++;*/
            //System.out.println(integers + " " + bucket + " " + counter);
        }
        
        return list;

    }

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));


        List<List<Integer>> queries = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("E:/testcase.txt"));
        try {
        	
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            int q = Integer.parseInt(line);
            while (line != null) {
                line = br.readLine();
                sb.append(line);
                sb.append(System.lineSeparator());
                if(line != null && !line.isEmpty()) {
                	String[] queriesRowTempItems = line.replaceAll("\\s+$", "").split(" ");
                    List<Integer> queriesRowItems = new ArrayList<>();

                    for (int j = 0; j < 2; j++) {
                        int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                        queriesRowItems.add(queriesItem);
                    }

                    queries.add(queriesRowItems);                	
                }
            }
        } finally {
            br.close();
        }
        

        List<Integer> ans = freqQuery(queries);

        for (int i = 0; i < ans.size(); i++) {
            bufferedWriter.write(String.valueOf(ans.get(i)));

            if (i != ans.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
