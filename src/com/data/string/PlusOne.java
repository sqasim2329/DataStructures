package com.data.string;

public class PlusOne {
	

    public int[] plusOne(int[] digits) {
        
        int n= digits.length;
        for(int i=0;i<digits.length;i++){
            if(digits[n-1-i]==9){
                digits[n-1-i]=0;
            }else{
                digits[n-1-i]++;
                return digits;
            }
            
        }
        digits= new int[digits.length+1];
        digits[0]=1;
        return digits;
        
        
    }

}
