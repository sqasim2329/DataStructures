package com.data.dynamicProgramming;

public class LongestValidParanthesis {
	
	public static void main(String args[]) {
	
	String s = ")()())";
	
	int l = 0;
	int r = 0;
	int max = 0;
	//(()
	for(int i=0;i < s.length();i++) {
		if(s.charAt(i)=='(')
			l++;
		else
			r++;
		
		if(l==r)
			max =Math.max(max, l+r);
		else if(r > l)//)(--case
		{
			l=0;
			r=0;
		}
			
	}
	
	for(int i=0;i<s.length();i++) {
		if(s.charAt(i)=='(')
			l++;
		else 
			r++;
		
		if(l==r)
			max =Math.max(max, l+r);
		else if(l > r)//)(--case
		{
			l=0;
			r=0;
		}
	}
	System.out.println(max);
	}


}
