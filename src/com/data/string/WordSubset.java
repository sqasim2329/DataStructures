package com.data.string;

import java.util.ArrayList;
import java.util.List;

public class WordSubset {
	
	public static List<String> wordSubsets(String[] A, String[] B){
		int tmp[] = new int[26];
		int counter[] = new int[26];
		List<String> res = new ArrayList<>();
		
		for(String str:B) {
			tmp=getCount(str);
			for(int i=0;i<26;i++) {
				counter[i]=Math.max(counter[i], tmp[i]);
			}
		}
		
		for(String str:A) {
			tmp = getCount(str);
            boolean isValid = true;
			for(int i=0;i<26;i++) {
				if(tmp[i] < counter[i]){
                    isValid = false;
                    break;
                }
					
			}
			if(isValid)
				res.add(str);
		}
		
		return res;
	}

	private static int[] getCount(String str) {
		int [] tmp = new int[26];
		for(char c:str.toCharArray())
			tmp[c-'a']++;
		return tmp;
	}
	
	public static void main(String args[]) {
	 String[] A = {"amazon","apple","facebook","google","leetcode"};
	 String[] B = {"e","o"};
	 for(String s:wordSubsets(A,B)) {
		 System.out.println(s);
	 }
	}

}
