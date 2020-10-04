package com.data.binaryTree;

import java.util.Stack;
//inorder using stack
public class CheckIfBST {
	
	class Solution {
	    public boolean isValidBST(TreeNode root) {
	        TreeNode prev = null;
	        Stack<TreeNode>  stk = new Stack<>();
	        while(root!=null || !stk.isEmpty()){
	            while(root!=null){
	                stk.push(root);
	                root = root.left;
	            }
	            root = stk.pop();
	            if(prev!= null &&  root.val <= prev.val)
	                return false;
	            prev = root;
	            root = root.right;
	        }
	        return true;
	    }
	}
	
	// but fails in cases where root has values as Integer.min and Integer.max hence better solution is above
	private boolean isValidBST(TreeNode root,int min,int max) {
		if(root == null)
			return true;
		if(root.val < min || root.val > max)
			return false;
		
		return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
	}


}
