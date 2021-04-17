package com.data.google.microsoft;

public class CountGoodNodeInBT {
	
	class Solution {
	    public int goodNodes(TreeNode root) {
	        int max = root.val;
	        
	        return dfs(root,root.val);
	    }
	    
	    private int dfs(TreeNode root, int max){
	        if(root == null)
	            return 0;
	        int count = 0;
	        if(max <= root.val) {
	            count++;
	            max = root.val;
	        }
	        count+=dfs(root.left,max);
	        count+=dfs(root.right,max);
	        return count;
	    }
	}

}
