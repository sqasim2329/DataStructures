package com.data.binaryTree;

public class PairsInBST {
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public boolean findTarget(TreeNode root, int k) {
	        Set<Integer> set= new HashSet<>();
	        return checkIfPairExists(root,k,set)>0;
	        
	        
	    }
	    
	    
	    public int checkIfPairExists(TreeNode root, int k, Set<Integer> set){
	        if(root==null) return 0;
	        
	        if(set.contains(root.val))
	            return 1;
	        set.add(k-root.val);
	        return checkIfPairExists(root.left,k,set) + checkIfPairExists(root.right,k,set); 
	    }
	}

}
