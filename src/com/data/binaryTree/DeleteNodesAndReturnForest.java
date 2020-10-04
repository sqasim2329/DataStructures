package com.data.binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
	
	class Solution {
	    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
	        List<TreeNode> remaining = new ArrayList<>();
	        Set<Integer> set = new HashSet<>();
	        for(int i:to_delete)
	            set.add(i);
	        
	        dfs(root,set,remaining);
	        if(!set.contains(root.val)){
	            remaining.add(root);
	        }
	        return remaining;
	    }
	    
	    
	    private TreeNode dfs(TreeNode root,Set<Integer> set,List<TreeNode> ls){
	        if(root == null)
	            return null;
	        
	       root.left= dfs(root.left,set,ls);
	        root.right = dfs(root.right,set,ls);
	        if(set.contains(root.val)){
	            if(root.left!=null)
	                ls.add(root.left);
	            if(root.right!=null)
	                ls.add(root.right);
	            
	            return null;
	            }
	        
	        return root;
	    }
	}
	

}
