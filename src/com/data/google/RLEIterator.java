package com.data.google;

public class RLEIterator {
	
	class RLEIterator {
	    
	    int index;
	    int[] A;

	    public RLEIterator(int[] A) {
	        this.index = 1;
	        this.A=A;
	     
	    }
	    
	    
	    public int next(int n) {
	        while(index < A.length && n > A[index-1]){
	            n = n-A[index-1];
	            index=index+2;
	        }
	        
	        if(index < A.length){
	            A[index-1] = A[index-1]-n;
	            return A[index];
	        }
	        
	        return -1;
	    }
	}

}
