package com.data.linkedin;

public class FindSmallestNumberGreaterThanTarget {
	
	class Solution {
	    public char nextGreatestLetter(char[] letters, char target) {
	        
	        char lo = letters[0];
	        char hi = letters[1];
	        return binarySearch(letters,target);
	    }
	    
	    private char binarySearch(char[] letters,char target){
	        int lo = 0;
	        int hi = letters.length;
	        while(lo < hi){
	            int mid = lo+(hi-lo)/2;
	            if(letters[mid]>target)
	                hi =  mid;
	            else
	                lo = mid+1;
	        }
	        return letters[lo%letters.length];
	    }
	}

}
