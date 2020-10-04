package com.data.stack;

import java.util.Stack;
//https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/
public class LargestRectangleHistogram {
	
	class Solution {
	    public int largestRectangleArea(int[] heights) {
	       
	        int i=0;
	        int n= heights.length;
	        int max= 0;
	        Stack<Integer> s = new Stack<>();
	        while(i < n){
	            while(!s.isEmpty() && heights[s.peek()] > heights[i] ){
	                int currHeight = heights[s.pop()];
	                int width = (i-(s.isEmpty()?0:s.peek()+1));
	                int area = currHeight * width;
	                max = Math.max(area,max);
	            }
	                            s.push(i);
	                            i++;
	        }
	                            
	        while(!s.isEmpty()){
	            int currHeight = heights[s.pop()];
	                int width = (i-(s.isEmpty()?0:s.peek()+1));
	                int area = currHeight * width;
	                max = Math.max(area,max);
	        }    
	                            
	                            return max;
	       
	    }
	}

	    
	 

}
