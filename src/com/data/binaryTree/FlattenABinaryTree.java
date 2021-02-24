package com.data.binaryTree;
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/ differenct from BTtoDLL
public class FlattenABinaryTree {
	
	    
	 public void flatten(TreeNode root) {
	        
	        dfs(root,null);
	    }
	    
	    private TreeNode dfs(TreeNode root, TreeNode pre){
	          if(root==null) return pre;
	        pre=dfs(root.right,pre);    
	        pre=dfs(root.left,pre);
	        root.right=pre;
	        root.left=null;
	        pre=root;
	        return pre;
	    }

}
