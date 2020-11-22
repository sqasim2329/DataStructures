package com.data.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReorderLogs {
	
public String[] reorderLogFiles(String[] logs) {
        
        if(logs== null || logs.length==0)
            return logs;
        
        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();
        
        for(String log:logs){
            String[] logArr = log.split("\\s+");
            if(Character.isLetter(logArr[1].charAt(0)))
                letterLogs.add(log);
            else
                digitLogs.add(log);
        }
        
        Collections.sort(letterLogs,new Comparator<String>(){
            
            public int compare(String a, String b){
                String[] log1Arr = a.split("\\s+",2);
                String[] log2Arr = b.split("\\s+",2);
                int comp = log1Arr[1].compareTo(log2Arr[1]);
                if(comp == 0)
                comp = log1Arr[0].compareTo(log2Arr[0]);
                return comp;
            }
        });
        letterLogs.addAll(digitLogs);
        return letterLogs.stream().toArray(String[]::new);
        
        
        
    }

}
/****
 * 
 * 
 * 		Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
		Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 
 * 
 * *****/
 