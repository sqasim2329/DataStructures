package com.data.binaryTree;
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/ differenct from BTtoDLL
public class FlattenABinaryTree {
	
	    
	    TreeNode prev = null;
	    public void flatten(TreeNode root) {
	        
	        if(root == null)
	            return;
	        
	       
	       
	        flatten(root.right);
	        flatten(root.left);
	        root.right = prev;
	        root.left = null;
	        prev = root;
	        
	        
	    }

}
