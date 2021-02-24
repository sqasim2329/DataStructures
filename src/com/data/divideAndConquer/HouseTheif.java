package com.data.divideAndConquer;

public class HouseTheif {
	
	public static void main(String args[]) {
		int arr[] = {6,7,1,30,2,4};
		System.out.println(getMaxStealth(arr,0));
		System.out.println(dp(arr));
	}

	private static int getMaxStealth(int[] arr, int index) {
		// TODO Auto-generated method stub
		if(index > arr.length-1) {
			return 0;
		}
		int currentHouseStealth = arr[index]+ getMaxStealth(arr,index+2);
		int skipCurrentHouseStealth = getMaxStealth(arr,index+1);
		return Math.max(currentHouseStealth, skipCurrentHouseStealth);
	}
	
	public int rob(int[] arr) {
        int n= arr.length;
        if(n==0 )
            return 0;
        if(n == 1)
            return arr[0];
		int dp[]= new int [n];
		int prev=arr[0];//dp[0]
		int curr=Math.max(arr[0],arr[1]);//dp[1]
		for(int i=2;i<n;i++) {
			int tmp=Math.max(curr, prev+arr[i]);
            prev = curr;
            curr = tmp;
		}
		return curr;
    }
	
	//rob 2
	public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        int startFromFirst = rob(nums,0,nums.length-2);
        int startFromNext = rob(nums,1,nums.length-1);
        return Math.max(startFromFirst,startFromNext);
    }
    
    private int rob(int[]nums,int start, int end){
        int curr =0;
        int prev =0;
        for(int i=start;i<=end;i++){
            int tmp = Math.max(curr,prev+nums[i]);
            prev =curr;
            curr =tmp;
            
        }
        return curr;
        
    }
	
    // rob 3
    class Solution {
        public int rob(TreeNode root) {
            
            if(root == null)
                return 0;
            
            return Math.max(include(root),exclude(root));// try to eclude and include
        }
        
        private int include(TreeNode root){
            if(root == null)
                return 0;
            
            return root.val+exclude(root.left)+exclude(root.right);//if include root exclude children
        }
        
        private int exclude(TreeNode root){
            if(root == null)
                return 0;
            
            return rob(root.left)+rob(root.right);//whatever node is to be excluded, 
            //there children can be included or excluded
        }
    }
	
	



}
