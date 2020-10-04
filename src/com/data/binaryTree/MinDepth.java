package com.data.binaryTree;

public class MinDepth {
	
	 public int minDepth(TreeNode root) {
	        
	        if(root == null)
	            return 0;
	        
	        int lh = minDepth(root.left);
	        int rh = minDepth(root.right);
	        
	        if(lh == 0 && rh == 0)
	            return 1;
	        else if(lh == 0) // if the left tree has no leaf node
	            return 1+rh;
	        else if(rh == 0)// if the right subtree has no lead node
	            return 1+lh;
	        else
	            return 1+Math.min(lh,rh); // if both the tree has leaf nodes
	        
	    }

}
