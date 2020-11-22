package com.data.heap;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
	
	class Solution {
	    public int[][] intervalIntersection(int[][] A, int[][] B) {
	        
	         List<int[]> ans = new ArrayList();
	    int i = 0, j = 0;

	    while (i < A.length && j < B.length) {
	     
	      int lo = Math.max(A[i][0], B[j][0]);
	      int hi = Math.min(A[i][1], B[j][1]);
	      if (lo <= hi)
	        ans.add(new int[]{lo, hi});

	     
	      if (A[i][1] < B[j][1])
	        i++;
	      else
	        j++;
	    }

	    return ans.toArray(new int[ans.size()][]);
	        
	    }
	}

}
/* 
 * 
 *  
 *  ------------------
 *  0  2  5 8
 *  l0 = 5
 *  hi = 2
 *  if(lo <= hi) will fail hecne we will not add to o/p array
 *  		
 *  
 *  */
