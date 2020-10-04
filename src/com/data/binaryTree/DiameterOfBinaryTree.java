package com.data.binaryTree;

public class DiameterOfBinaryTree {
	
	 int max = Integer.MIN_VALUE;
	    public int diameterOfBinaryTree(TreeNode root) {
	       
	        dfs(root);
	        return max != Integer.MIN_VALUE?max-1:0;
	    }
	    
	    private int dfs(TreeNode root){
	        if(root==null)
	            return 0;
	        int lh = dfs(root.left);
	        int rh = dfs(root.right);
	        
	        max = Math.max(max,lh+rh+1);
	        return 1+Math.max(lh,rh);
	    }

}
