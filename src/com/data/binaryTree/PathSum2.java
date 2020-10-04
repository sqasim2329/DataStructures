package com.data.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
	
	class Solution {
	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        
	        List<List<Integer>> res = new ArrayList<>();
	        List<Integer> ls = new LinkedList<>();
	        dfs(root,sum,0,ls,res);
	        return res;
	    }
	    
	    private void dfs(TreeNode root,int sum,int curr,List<Integer> ls,List<List<Integer>> res){
	        if(root == null)
	            return;
	        
	        ls.add(root.val);
	        if(root.left == null && root.right== null && curr+root.val == sum){
	            res.add(new LinkedList(ls));
	        }
	        else{
	            curr = curr+root.val;
	            dfs(root.left,sum,curr,ls,res);
	            dfs(root.right,sum,curr,ls,res);
	        }
	        ls.remove(ls.size()-1);
	        
	    }
	}

}
