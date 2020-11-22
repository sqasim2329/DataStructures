package com.data.string;

public class OneEditDistance {
	

    public boolean isOneEditDistance(String s, String t) {
        
        int n1 = s.length();
        int n2 = t.length();
        
        if(Math.abs(n1-n2)>1)
            return false;
        
        int i = 0;
        int j = 0;
        while(i< n1 && j < n2 && s.charAt(i)==t.charAt(j)){
            i++;j++;
        }
        
        if(i==n1 && j ==n2)
            return false;
        
        if(n1 > n2){
            return s.substring(i+1).equals(t.substring(j));
        }else if(n1 < n2){
            return s.substring(i).equals(t.substring(j+1));
        }else{
            return s.substring(i+1).equals(t.substring(j+1));
        }
        
    }

}
