 package com.data.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Strobogrammatic1 {
	
	
	    public boolean isStrobogrammatic(String num) {
	    	
	        Map<Character,Character> freq =new HashMap<>();
	        freq.put('6','9');
	        freq.put('9','6');
	        freq.put('1','1');
	        freq.put('0','0');
	        freq.put('8','8');
	        int l=0;
	        int r= num.length()-1;
	        while(l<=r){
	            if(!freq.containsKey(num.charAt(l)))
	                return false;
	            else if(freq.get(num.charAt(l))!= num.charAt(r)){
	                return false;
	            }
	            l++;
	            r--;
	        }
	        
	        return true;
	        
	        
	        
	    }
	    
	    public static List<String> findStrobogrammatic(int n) {
	        return helper(n, n);
	    }

	    static List<String> helper(int n, int m) {
	        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
	        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
	        
	        List<String> list = helper(n - 2, m);
	        
	        List<String> res = new ArrayList<String>();
	        
	        for (int i = 0; i < list.size(); i++) {
	            String s = list.get(i);
	            
	            if (n != m) res.add("0" + s + "0");
	            
	            res.add("1" + s + "1");
	            res.add("6" + s + "9");
	            res.add("8" + s + "8");
	            res.add("9" + s + "6");
	        }
	        
	        return res;
	    }
	    
	    public static void main(String args[]) {
	    	
	    	System.out.println(findStrobogrammatic(4));
	    	
	    }

}
