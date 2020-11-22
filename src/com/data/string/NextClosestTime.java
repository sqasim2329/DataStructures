package com.data.string;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
	
	public String nextClosestTime(String time) {
        int min = Integer.parseInt(time.substring(0,2))*60;
        min+=Integer.parseInt(time.substring(3));
        
        Set<Integer> allowed = new HashSet<>();
        for(char c:time.toCharArray()){
            if(c!=':')
                allowed.add(c-'0');
        }
        
        
        while(true){
            boolean isValid = true;
            min= (min+1)%(24*60);
            int[] nextTime = {min/60/10,min/60%10,min%60/10,min%60%10};
            for(int i:nextTime){
                if(!allowed.contains(i)){
                   isValid =false;
                     break;
                }
            }
            
            if(isValid)
                break;
        }
        
        return String.format("%02d:%02d",min/60,min%60);

	}
}	
	
