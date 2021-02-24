package com.data.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PrintUniqueRows {
	
	
	public static void main(String args[]) {
		int arr[][] = {{0, 1, 0, 0, 1}, 
		        {1, 0, 1, 1, 0}, 
		        {0, 1, 0, 0, 1}, 
		        {1, 0, 1, 0, 0} 
		    }; 
		
		
		Set<String> set = new HashSet<>();
		
		for(int i=0;i<arr.length;i++) {
			String s = "";
			for(int j=0;j<arr[i].length;j++) {
				s = s+arr[i][j];
				}
			
			if(!set.contains(s)) {
				set.add(s);
				System.out.println(s);
			}
			}
		
		
		
	}

}


public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
{
    Map<String,int[]> map = new LinkedHashMap<>();
    for(int i=0;i<r;i++){
        int[] tmp = a[i];
        String key=Arrays.toString(tmp);
        map.put(key,tmp);
    }
    
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    for(Map.Entry<String,int[]> e:map.entrySet()){
        ArrayList<Integer> sub = new ArrayList<>();
        for(int i:e.getValue()){
            sub.add(i);
        }
        res.add(sub);
    }
    return res;
}

//O(r)+O(r*c);
//O(r*c);