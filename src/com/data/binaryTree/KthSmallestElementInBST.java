package com.data.binaryTree;

public class KthSmallestElementInBST {
	
	 class Count{
	        int c;
	        int val;
	    }
	    public int kthSmallest(TreeNode root, int k) {
	        Count c = new Count();
	        c.c=0;
	        dfs(root,k,c);
	        return c.val;
	    }
	    
	    private void dfs(TreeNode root,int k,Count c){
	    	 if(root == null)
	             return;
	         
	         dfs(root.left,k,c);
	         c.c++;
	         if(c.c==k && c.val==-1){
	             c.val = root.val;
	             return;
	         }else if(c.val!=-1){//just adding else without if condition will cause the below statemnt to unreachable
	             return;// return once you have found the val
	         }
	         dfs(root.right,k,c);
	            
	    }

}


//https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/--read follow up