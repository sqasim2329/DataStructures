package com.data.binaryTree;

public class CheckForBalancedTree {
	
	class Height{
        int h;
    }
    
     /* This function should return tree if passed  tree 
     is balanced, else false. */
    boolean isBalanced(Node root)
    {
    Height height = new Height();    
	return dfs(root,height);
    }
    
    
    private boolean dfs(Node root,Height height){
        if(root == null){
        height.h = 0;
        return true;
        }
        
        Height lheight = new Height();
        Height rheight = new Height();
        
        boolean l = dfs(root.left,lheight);
        boolean r = dfs(root.right,rheight);
        int lh = lheight.h;
        int rh = rheight.h;
        height.h = 1+Math.max(lh,rh);
        
        if(Math.abs(lheight.h - rheight.h) > 1)
        return false;
        
        return l && r;
    }

}
