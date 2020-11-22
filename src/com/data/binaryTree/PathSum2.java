package com.data.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	//Path sum1
	 public boolean hasPathSum(TreeNode root, int sum) {
	        if(root == null)
	            return false;
	        
	        if(root.left==null && root.right == null)
	            return sum-root.val ==0;
	        
	        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
	        
	        
	    }
	 
	 public int pathSum3(TreeNode root, int sum) {
	        int count =0;
	        int currSum = 0;
	        Map<Integer,Integer> prefix = new HashMap<>();
	        return dfs(root,currSum,count,sum,prefix);
	    }
	    
	    private int dfs(TreeNode root,int currSum, int count,int sum,Map<Integer,Integer> prefix){
	        if(root == null)
	            return count;
	        
	        currSum+=root.val;
	        if(currSum == sum)
	            count++;
	        count += prefix.getOrDefault(currSum-sum,0);
	        prefix.put(currSum,prefix.getOrDefault(currSum,0)+1);
	        count=dfs(root.left,currSum,count,sum,prefix);
	        count=dfs(root.right,currSum,count,sum,prefix);
	        prefix.put(currSum,prefix.getOrDefault(currSum,0)-1);
	        return count;
	        
	    }

}
