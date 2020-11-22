package com.data.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxLevelSumBinaryTree {
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	 
	class Solution {
	    public int maxLevelSum(TreeNode root) {
	        Queue<TreeNode> queue= new LinkedList<>();
	        int fsum=Integer.MIN_VALUE;
	        int ans=0;
	        int l=0;
	        queue.add(root);        
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            l++;
	            int sum=0;
	            for(int i=0;i<size;i++){
	                TreeNode r = queue.poll();
                    sum+=r.val;
	                if(r.left!=null){
	                    queue.add(r.left);
	                }
	                if(r.right!=null){
	                    queue.add(r.right);
	                }
	            }
	            
	            if(sum>fsum){
	                fsum=sum;
	                ans=l;
	        }
	        
	        
	    }
	        return ans;
	        }
	    
	    public int maxLevelSumDFS(TreeNode root) {
	        List<Integer> res = new ArrayList<>();
	        int level =0;
	        int resSum = Integer.MIN_VALUE/10;
	        dfs(res,root,0);
	        for(int i=0;i<res.size();i++){
	            if(resSum < res.get(i)){
	                level= i+1;
	                resSum = res.get(i);
	            }
	        }
	        return level;
	    }
	    
	    private void dfs(List<Integer> res, TreeNode root, int level){
	        if(root == null)
	            return ;
	        
	        if(res.size()==level){
	            res.add(0);
	        }
	        
	        int sum = res.get(level);
	        sum+=root.val;
	        res.set(level,sum);
	        dfs(res,root.left,level+1);
	        dfs(res,root.right,level+1);
	        
	    }
	    
	}
}
