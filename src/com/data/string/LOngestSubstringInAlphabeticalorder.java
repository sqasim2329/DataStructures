package com.data.string;

public class LOngestSubstringInAlphabeticalorder {
	
	public static void main(String args[]) {
		String s= "zabcd";
//		String s= "abcabcdefabc";
		
		int i =0;
		int index =0;
		int len = Integer.MIN_VALUE;
		while(i<s.length()) {
			index =i;
			while(i < s.length()-1 && (s.charAt(i+1)-s.charAt(i) == 1 || s.charAt(i)=='z' && s.charAt(i+1)=='a')) {
				i++;	
			}
			len = Math.max(len,i-index+1);
			i++;
		}
		System.out.println(len);
		
		
	}

}
