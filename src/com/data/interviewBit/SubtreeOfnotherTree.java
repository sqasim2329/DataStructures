package com.data.interviewBit;

public class SubtreeOfnotherTree {
	
	class Solution {
	    public boolean isSubtree(TreeNode s, TreeNode t) {
	        if(s == null)
	            return false;
	        else if(isSameTree(s,t))
	            return true;
	        else
	            return isSubtree(s.left,t)||isSubtree(s.right,t);
	            
	        
	    }
	    
	    private boolean isSameTree(TreeNode s, TreeNode t){
	        if(s == null || t == null )
	            return s == null && t == null;
	        
	        if(s.val != t.val)
	            return false;
	        
	        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
	    }
	}

}
