package com.data.google;

public class IntegerReplcaement {
	

    Map<Integer,Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
            if(map.containsKey(n))
                return map.get(n);
        if( n == 1 )
            return 0;
        
        if(n == Integer.MAX_VALUE)
            return 32;
        
        if(n < 1 )
            return Integer.MAX_VALUE;
        
        int result =0;
        if(n%2 == 0)
        result = 1+integerReplacement(n/2);
        else 
       result = 1+Math.min(integerReplacement(n-1),integerReplacement(n+1));
        map.put(n,result);
        return result;
    }

}
