package com.data.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
	
	
	    public List<String> letterCombinations(String digits) {
	        Map<String,String> phone = new HashMap<>();
	        phone.put("2","abc");
	        phone.put("3","def");
	        phone.put("4","ghi");
	        phone.put("5","jkl");
	        phone.put("6","mno");
	        phone.put("7","pqrs");
	        phone.put("8","tuv");
	        phone.put("9","wxyz");
	        List<String> res = new ArrayList<>();
	        backTrack("",digits,res,phone);
	        return res;
	        
	    }
	    
	    private void backTrack(String comb,String digits,List<String> res,Map<String,String> phone){
	        if(digits.length()==0){
	            if(comb!="")
	            res.add(comb);
	            return;
	        }
	        
	        String digit = digits.substring(0,1);
	        String letters = phone.get(digit);
	        for(int i=0;i<letters.length();i++){
	            backTrack(comb+letters.charAt(i),digits.substring(1),res,phone);
	        }
	        
	    }
	    
	    public static void main(String args[]) {
	    	String digits = "2339";
	    	LetterCombinationsOfPhoneNumber  bt = new LetterCombinationsOfPhoneNumber();
	    	System.out.println(bt.letterCombinations(digits));
	    }

}
