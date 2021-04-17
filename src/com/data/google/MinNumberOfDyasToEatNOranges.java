package com.data.google;

public class MinNumberOfDyasToEatNOranges {
	
	Map<Integer, Integer> map = new HashMap<>();
    public int minDays(int n) {
//         if(map.containsKey(n))
//             return map.get(n);
//         if(n == 0)
//             return 0;
//         if(n==1)
//             return 1;

//         int ans = n;
        
//         ans = Math.min(ans,1+minDays(n-1));
        
//         if(n%2 == 0){
//             ans = Math.min(ans,1+minDays(n-n/2));
//         }
//         if(n%3 == 0)
//             ans = Math.min(ans,1+minDays(n-(2*n/3)));
        
        if(n <= 1)
            return n;
        
        if(map.containsKey(n))
            return map.get(n);
        
        int ans = n;
        
        ans = Math.min(ans,1+Math.min(n%2+minDays(n/2),n%3+minDays(n/3)));
        
        map.put(n,ans);
        return ans;
    }

}
/**
 * 
 *  n%2 is the remoaning which needs to be redcued by n-1
 *  n%3 is the remoaning which needs to be redcued by n-1 
 *  
 *  n-2*n/3--> n/3 
 *  
 * 
 * 
 * **/
 