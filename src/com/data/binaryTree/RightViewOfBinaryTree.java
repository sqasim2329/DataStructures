package com.data.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBinaryTree {
	
	class Solution {
	    
	    public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> res =new ArrayList<>();
	        solve(res,root,0);
	        return res;
	    }
	    
	    
	    private void solve(List<Integer> ls,TreeNode root, int level){
	        if(root==null)
	            return;
	        
	        if(ls.size() == level)
	        {
	            ls.add(root.val);
	        }
	        
	        solve(ls,root.right,level+1);
	        solve(ls,root.left,level+1);
	        // for left view interchange the above two lines
	    }
	}

}

//https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/


class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        res.add(root.val);
        boundaryForLeft(root.left,res);
        boundaryForLeaves(root.left,res);
        boundaryForLeaves(root.right,res);
        boundaryForRight(root.right,res);
        return res;
    }
    
    private void boundaryForLeft(TreeNode root,List<Integer> ls){
        if(root == null || (root.left==null && root.right == null))
            return;
        ls.add(root.val);
        if(root.left==null) boundaryForLeft(root.right,ls);
        else boundaryForLeft(root.left,ls);
        
    }
    
    private void boundaryForRight(TreeNode root,List<Integer> ls){
        if(root == null || (root.left==null && root.right == null))
            return;
        
       if(root.right==null) boundaryForRight(root.left,ls);
        else boundaryForRight(root.right,ls);
        ls.add(root.val);
        
    }
    
    private void boundaryForLeaves(TreeNode root,List<Integer> ls){
        if(root == null)
            return;
        
        
        boundaryForLeaves(root.left,ls);
        if(root.left==null && root.right == null)
            ls.add(root.val);
        boundaryForLeaves(root.right,ls);
        
        
    }