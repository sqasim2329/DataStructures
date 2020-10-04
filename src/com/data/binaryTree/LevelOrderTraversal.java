package com.data.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {
	
	class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<>();
	        dfs(res,root,0);
	        return res;
	        
	    }
	    
	    private void dfs(List<List<Integer>> res,TreeNode root, int level){
	        if(root == null)
	            return;
	        
	        if(res.size()<=level)
	        {
	            LinkedList<Integer> ls = new LinkedList<>();
	            res.add(ls);
	        }
	        
	        List<Integer> coll = res.get(level);
	        coll.add(root.val);
	        
	        dfs(res,root.left,level+1);
	        dfs(res,root.right,level+1);
	    }
	}

}
// bfs can be done using queue , but if to be done using dfs then use this above method
