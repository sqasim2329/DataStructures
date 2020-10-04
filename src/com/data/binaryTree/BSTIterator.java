package com.data.binaryTree;

import java.util.Stack;

public class BSTIterator {
	
	class Solution {
	    Stack<TreeNode> stk ;
	    public Solution(TreeNode root) {
	        
	        stk = new Stack<>();
	        addToStack(stk,root);
	        
	    }
	    
	    private void addToStack(Stack<TreeNode> stk,TreeNode root){
	        while(root!=null){
	                
	            root = root.left;
	        }
	    }
	    
	    /** @return the next smallest number */
	    public int next() {
	        TreeNode top = stk.pop();
	        if(top.right!=null)
	            addToStack(stk,top.right);
	        return top.val;
	    }
	    
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stk.isEmpty();
	    }
	}

}
