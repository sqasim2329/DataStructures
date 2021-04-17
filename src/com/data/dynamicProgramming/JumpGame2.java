package com.data.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

//min jumps to reach end of 2d array
public class JumpGame2 {
	
	public int jump(int[] nums) {
        int n= nums.length;
        if(n == 0)
            return 0;
        int []dp = new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if(nums[j]>=(i-j))
                dp[i] = Math.min(dp[i],1+dp[j]);
            }
        }
        return dp[n-1];
        
        
    }
	//Jump Game 3
	class Solution {
	    
	    public boolean canReach(int[] arr, int start) {
	        Set<Integer> set = new HashSet<>();
	        return canReach(arr,start,set);
	    }
	    
	    private boolean canReach(int[] arr, int start, Set<Integer> set){
	        if(start >= arr.length || start < 0)
	            return false;
	        
	        if(arr[start] == 0)
	            return true;
	       
	        if(!set.contains(start)){
	            set.add(start);
	            return canReach(arr,start+arr[start],set)||canReach(arr,start-arr[start],set);
	        }
	       
	        
	        return false;
	    }
     

}
	
	
	
	class Solution {
	    public int jump(int[] nums) {
	        if(nums[0]==0 || nums.length==1)
	            return 0;
	        int farthest = nums[0];
	        int currEnd = nums[0];
	        int n = nums.length;
	        int jumps=1;
	        for(int i=1;i<n;i++){
	            if(i == n-1)
	                return jumps;
	            farthest = Math.max(farthest,i+nums[i]);
	            if(currEnd ==i){
	                jumps++;
	                currEnd =farthest;
	            }
	            
	        }
	        return jumps;
	        
	    }
	}
	
	///jump game 4
	class Solution {
	    public int minJumps(int[] nums) {
	        
	        Map<Integer,List<Integer>> graph = new HashMap<>();
	        for(int i=0;i<nums.length;i++){
	            graph.putIfAbsent(nums[i],new ArrayList<>());
	            graph.get(nums[i]).add(i);
	        }
	        
	        Queue<Integer> q = new LinkedList<>();
	        Set<Integer> visited = new HashSet<>();
	        q.add(0);
	        visited.add(0);
	        int steps = 0;
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int i=0;i<size;i++){
	                int indx = q.poll();
	                if(indx == nums.length-1)
	                    return steps;
	                List<Integer> adj = graph.get(nums[indx]);
	                adj.add(indx+1);
	                adj.add(indx-1);
	                for(int j:adj){
	                    if(j < nums.length && j>=0 && !visited.contains(j)){
	                        visited.add(j);
	                        q.add(j);
	                    }
	                }
	                adj.clear();
	            }
	            
	            steps++;
	        }
	        
	        return steps;
	        
	    }
	}
	    
