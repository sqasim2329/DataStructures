package com.data.binaryTree;

public class SumOfAllRootToLeaves {
	
	class Solution {
	    public int sumNumbers(TreeNode root) {
	        
	        
	        return dfs(root,0);
	        
	        
	    }
	    
	    private int dfs(TreeNode root, int curr){
	        if(root == null)
	            return 0;
	        
	        if(root.left==null && root.right == null) return curr*10+root.val;
	        return dfs(root.left,curr*10+root.val)+dfs(root.right,curr*10+root.val);
	        
	            
	    }

}
