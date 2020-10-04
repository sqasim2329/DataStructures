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


class Solution{
	
	public List<Integer> boundaryTraversal(TreeNode root){
		List<Integer> ls=  new ArrayList<>();
		ls.add(root.val);// added root
		boundaryLeft(root.left,ls);
		boundaryLeaves(root.left,ls);
		boundaryLeaves(root.right,ls);
		boundaryRight(root.left,ls);
		return ls;
		
	}
	
	private void boundaryLeft(TreeNode root,List<Integer> ls) {
		if(root == null)
			return;
		
		
		if(root.left!=null) {
			ls.add(root.val);
			boundaryLeft(root.left,ls);
		}
		
		else if(root.right!=null) {
			ls.add(root.val);
			boundaryLeft(root.right,ls);
		}
	} 
	
	
	private void boundaryLeaves(TreeNode root,List<Integer> ls) {
		if(root == null)
			return;
		boundaryLeaves(root.left,ls);
		if(root.left == null && root.right == null)
			ls.add(root.val);
		boundaryLeaves(root.right,ls);
	}
	
	private void boundaryRight(TreeNode root,List<Integer> ls) {
		if(root == null)
			return;
		
		if(root.right!=null) {
			boundaryRight(root.right,ls);
			ls.add(root.val);
		}else if(root.left!=null) {
			boundaryRight(root.left,ls);
			ls.add(root.val);
		}
	}
}