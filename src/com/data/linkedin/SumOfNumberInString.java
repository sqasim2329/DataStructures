package com.data.linkedin;

public class SumOfNumberInString {
	
	class Solution{
	    // Function to find the sum of all
	    // the numbers in the given string s
	    public static long findSum(String s){
	        int sum = 0;
	        int num =0;
	       for(char c:s.toCharArray()){
	           if(Character.isDigit(c)){
	               num=num*10+c-'0';
	           }else{
	               sum+=num;
	               num = 0;
	           }
	       }
	       
	        return sum+num;
	    }
	    
	}

}
