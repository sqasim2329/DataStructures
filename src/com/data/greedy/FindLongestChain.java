package com.data.greedy;

import java.util.Arrays;

public class FindLongestChain {
	
public int findLongestChain(int[][] pairs) {
        
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int prev = pairs[0][1];
        int cnt=1;
        for(int i=1;i<pairs.length;i++){
            if(prev < pairs[i][0]){
                prev =pairs[i][1];
                cnt++;
            }
        }
        
        return cnt;
        
    }

}
