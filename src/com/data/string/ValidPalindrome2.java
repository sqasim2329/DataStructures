package com.data.string;

public class ValidPalindrome2 {
	
	 public static boolean validPalindrome(String s) {
	        int i =0;
	        int j =s.length()-1;
	        while(i<=j){
	            if(s.charAt(i)!=s.charAt(j)){
	                return isPalindrome(i+1,j,s) || isPalindrome(i,j-1,s);
	            }
	            else{
	                i++;
	                j--;
	            }
	        }
	        return true;
	    }
	    
	    
	    private static boolean isPalindrome(int i, int j, String s){
	        while(i<=j){
	            if(s.charAt(i)!=s.charAt(j))
	                return false;
	            else{
	                i++;
	                j--;
	            }
	            
	        }
	        return true;
	    }
	    
	    public static void main(String args[]) {
	    	String s = "cbbcc";
	    	System.out.println(validPalindrome(s));
	    }


}
