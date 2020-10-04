package com.data.string;

import java.util.Arrays;

// O(n) && O(1) space--O(1) space means this program will always use the same space for calculation no matter the input
public class RemoveDuplicates {          
	
	public static void main(String args[]) {
		String s = "characters";
		char[] str = s.toCharArray();
		int freq[] = new int[26];
		int end =0;
		for(int i = 0; i< str.length;i++) {
			if(freq[str[i]-'a']==0) {
				freq[str[i]-'a'] =1;
				str[end++] = str[i];
			}
		}
		
		System.out.println(Arrays.copyOfRange(str, 0, end));
	}

}
