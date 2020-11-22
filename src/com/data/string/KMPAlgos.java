package com.data.string;

import java.util.Arrays;

public class KMPAlgos {
	
	public static boolean KMPSearch(int lps[],String text,String pat) {
		int n = text.length();
		int m = pat.length();
		int i=0,j=0;
		while(i < n) {
			if(text.charAt(i)==pat.charAt(j)) {
				i++;
				j++;
				if(j==m)
					j = lps[j-1];//for multiple findings
			}else {
				if(j!=0) {
					j = lps[j-1];
				}else {
					i++;
				}
			}			
		}
		if(j==m) {
			System.out.println(i-m);
			return true;//index will be i-m+1;
		}
		
		return false;
	}
	
	public static int[] computeLPSArray(String pat) {
		int length = pat.length();
		int lps[]= new int[length];
		int i=1,j=0;
		lps[0]=0;
		while( i < length) {
			if(pat.charAt(i)==pat.charAt(j)) {
				j++;
				lps[i]=j;
				i++;
			}else {
				if(j==0) {
					lps[i]=0;
					i++;
				}else {
					j=lps[j-1];
				}
			}
		}
		
		return lps;
	}
	
public static void main(String args[]){
        
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        int lps[] = computeLPSArray(subString);
        boolean result = KMPSearch(lps,str,subString);
        System.out.print(result);
        
    }
}


