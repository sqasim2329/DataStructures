package com.data.google.microsoft;

public class MinimumNumberOFAdjacentSwapsToConvertStringtoAnagram {
	
	public static void main(String args[]) {
		
		String s1 = "abcfdegji";
		String s2 = "fjiacbdge";
		char[] s1a = s1.toCharArray();
		char[] s2a = s2.toCharArray();
		int result = 0;
		for(int i=0;i<s1.length();i++) {
			int j =i;
			while(j < s2.length() && s1a[i]!=s2a[j]) {
				j++;
			}
			if( i == j )continue;
			while(i < j) {
				char tmp = s2a[j];
				s2a[j]=s2a[j-1];
				s2a[j-1]=tmp;
				j--;
				result++;
			}
		}
		
		System.out.println(result);
		
	}

}
