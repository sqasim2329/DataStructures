package com.data.string;

public class ImplementStrStr {
	public static int strStr(String haystack, String needle) {
        int count =0;
        int n1 = haystack.length();
        int n2 = needle.length();
        for(int i=0;i<=n1-n2;i++) {
        	while(count < n2 && haystack.charAt(i+count)== needle.charAt(count))
        		count++;
        	if(count == n2)
        		return i;
        	count =0;
        }
        return -1;
        }
	
	
	public static void main(String args[]) {
		System.out.println(strStr("mississippi","issip"));
	}
	
	

}
