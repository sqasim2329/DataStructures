package com.data.arrays;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	

    public int romanToInt(String s) {
        Map<Character,Integer> romanToInteger = new HashMap<>();
        romanToInteger.put('I',1);
        romanToInteger.put('V',5);
        romanToInteger.put('X',10);
        romanToInteger.put('L',50);
        romanToInteger.put('C',100);
        romanToInteger.put('D',500);
        romanToInteger.put('M',1000);
        
        return generateNum(s,romanToInteger);
        
    }
    
    private int generateNum(String s, Map<Character,Integer> romanToInteger){
        int n = s.length();
        int r=0;
        int sum =0;
        while(r<n){
            if(r < n-1 && romanToInteger.get(s.charAt(r))<romanToInteger.get(s.charAt(r+1))){
                sum+=romanToInteger.get(s.charAt(r+1))-romanToInteger.get(s.charAt(r));
                r=r+2;
            }else{
                sum+=romanToInteger.get(s.charAt(r));
                r=r+1;
            }
        }
        
        return sum;
    }

}
