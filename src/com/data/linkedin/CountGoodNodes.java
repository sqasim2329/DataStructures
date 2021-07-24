package com.data.linkedin;

public class CountGoodNodes {
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	class Solution {
	    class Pair{
	        int max = 0;
	        TreeNode node;
	        public Pair(TreeNode root,int max){
	            this.max = max;
	            this.node = root;
	        }
	    }
	    public int goodNodes(TreeNode root) {
	        int count = 0;
	        Queue<Pair> q = new LinkedList<>();
	        q.add(new Pair(root,root.val));
	        while(!q.isEmpty()){
	            Pair p = q.poll();
	            TreeNode node = p.node;
	            int max = p.max;
	            if(max <= node.val){
	                count++;
	                max = node.val;
	            }
	            if(node.left!=null)
	                q.add(new Pair(node.left,max));
	            
	            if(node.right!=null)
	                q.add(new Pair(node.right,max));
	        }
	        return count;
	    }
	    
//	     private int dfs(TreeNode root, int max){
	       
//	         if(root == null)
//	             return 0;
//	         int count =0;
//	         if(max <= root.val){
//	             count++;
//	             max = root.val;
//	         }
	        
//	         count+=dfs(root.left,max);
//	         count+=dfs(root.right,max);
//	         return count;
	        
	        
//	     }
	}

}
