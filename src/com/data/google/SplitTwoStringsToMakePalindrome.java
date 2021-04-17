package com.data.google;

public class SplitTwoStringsToMakePalindrome {
	
	 public boolean checkPalindromeFormation(String a, String b) {
	        return check(a,b) || check(b,a);
	    }
	    
	    private boolean check(String a, String b){
	        int l =0;
	        int r =b.length()-1;
	        while(l < r){
	            if(a.charAt(l)!=b.charAt(r))
	                break;
	            l++;r--;
	        }
	        
	        return isPalindrome(a,l,r) || isPalindrome(b,l,r);
	    }
	    
	    public boolean isPalindrome(String a, int i, int j){
	        while(i < j){
	            if(a.charAt(i)!=a.charAt(j))
	                return false;
	            i++;j--;
	        }
	        return true;
	    }

}



//check https://leetcode.com/problems/letter-case-permutation/

//abd   ab // if it is odd we have to worry abt middle part as well
//
//fec  ef
//
//
//
//ula cfd // if it is even then we dont have worry abt middle part as in this example
//
//jiz alu