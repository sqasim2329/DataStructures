package com.data.arrays;

public class isPalindrome {
	
	public boolean isPalindrome(int x) {
        if( x < 0)
            return false;
        int original = x;
        int reversed =0;
        while(x!=0){
            int tmp = x%10;
            reversed = reversed *10+tmp;
            x =x/10;
        }
        
        return reversed==original;
    }

}
