package backTracking;

public class PartitionKEqualSubSetSum {
	
	class Solution {
	    public boolean canPartitionKSubsets(int[] nums, int k) {
	        int sum = 0 ;
	        for(int n:nums){
	            sum+=n;
	        }
	        
	        if(sum%k != 0)
	            return false;
	        boolean[] vis = new boolean[nums.length];
	        return backTrack(0,0,nums,vis,sum/k,k);
	        
	    }
	    
	    private boolean backTrack(int start,int curr,int[] nums,boolean[] vis,int target, int k){
	        
	        if(k == 1)
	            return true;
	        
	        if(curr == target)
	            return backTrack(0,0,nums,vis,target,k-1);
	        
	        
	        for(int i=start;i<nums.length;i++){
	            if(!vis[i]){
	                vis[i]=true;
	                if(backTrack(i+1,curr+nums[i],nums,vis,target,k))
	                    return true;
	                vis[i]=false;
	            }
	        }
	        
	        return false;
	    }
	}



}
