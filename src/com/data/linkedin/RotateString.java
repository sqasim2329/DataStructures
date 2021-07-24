package com.data.linkedin;

public class RotateString {
	
	class Solution {
	    public boolean rotateString(String A, String B) {
	        if(A.length()!=B.length())
	            return false;
	       A = A+A;
	       return A.indexOf(B)>-1; 
	        
	        
	    }
	}

}
