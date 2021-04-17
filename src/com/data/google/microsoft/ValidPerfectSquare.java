package com.data.google.microsoft;

public class ValidPerfectSquare {
	// square number. = 1+3+5+7....
	public boolean isPerfectSquare(int num) {
        int i=1;
        while(num > 0){
            num-=i;
            i+=2;
        }
        return num==0;
    }
	
	public boolean isPerfectSquare(int num) {
	       long l = 1 ; 
	       long r = num;
	        while(l <= r){
	            long mid = l+(r-l)/2;
	            if( mid*mid == num )
	                return true;
	            if( mid*mid < num )
	                l = mid+1;
	            else if( mid*mid > num)
	                r= mid-1;
	        }
	        return false;
	    }

}
