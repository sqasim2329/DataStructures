package com.data.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextgreaterInRotatedArray {
	
	public static void main(String args[]) {
		NextgreaterInRotatedArray m= new NextgreaterInRotatedArray();
		int[]nums = {1,2,1};
		System.out.println(m.nextGreaterElements(nums));
	}
	
        
	 private  int[] nextGreaterElements(int[] nums) {
	        
	        int [] res = new int[nums.length];
	        Stack<Integer> stk = new Stack<>();
	        Arrays.fill(res,-1);// if no greater elem then return -1
	        int n = nums.length;
	        for(int i=0;i<n*2;i++){
	            while(!stk.isEmpty() && nums[stk.peek()] < nums[i%n]){
	                res[stk.pop()] = nums[i%n];
	            }
	            stk.push(i%n);
	        }   
	        return res; 
	    }
    
    
        
    }


