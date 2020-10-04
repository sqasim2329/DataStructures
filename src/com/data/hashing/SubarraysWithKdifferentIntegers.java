package com.data.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKdifferentIntegers {
	
	public static int subarraysWithKDistinct(int[] A, int K) {
        return solve(A,K)-solve(A,K-1);
    }
    
    private static int solve(int []a,int k){
        Map<Integer,Integer> map = new HashMap<>();
        int right =0;
        int left =0;
        int count=0;
        int res= 0;
        while(right < a.length){
            map.put(a[right],map.getOrDefault(a[right],0)+1);
            if(map.get(a[right])==1)
                count++;
            right++;
            while(count > k){
                map.put(a[left],map.get(a[left])-1);
                if(map.get(a[left])==0)
                    count--;
                left++;
            }
            res += right-left+1;
        }
        return res;
    }
    
    public static void main(String args[]) {
    	int a[]= {1,2,1,2,3};
    	System.out.println(subarraysWithKDistinct(a,2));
    }

}
