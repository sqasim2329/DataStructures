package com.data.binaryTree;

public class SumOfAllRootToLeaves {
	
	class Solution {
	    public int sumNumbers(TreeNode root) {
	        
	        
	        return dfs(root,0);
	        
	        
	    }
	    
	    private int dfs(TreeNode root, int curr){
	        if(root == null)
	            return 0;
	        
	        if(root.left==null && root.right == null) return curr*10+root.val;
	        return dfs(root.left,curr*10+root.val)+dfs(root.right,curr*10+root.val);
	        
	            
	    }
	    
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
	            TreeNode node;
	            int curr;
	                
	                public Pair(TreeNode node, int curr){
	                    this.node = node;
	                    this.curr = curr;
	            }
	        }
	        public int sumNumbers(TreeNode root) {
	            Queue<Pair> q = new LinkedList<>();
	            q.add(new Pair(root,0));
	            int sum = 0;
	            while(!q.isEmpty()){
	                Pair p = q.poll();
	                TreeNode node = p.node;
	                int curr = p.curr;
	                
	                curr = curr*10+node.val;
	                if(node.left == null && node.right == null)
	                    sum+=curr;
	                if(node.left!=null)
	                    q.add(new Pair(node.left,curr));
	                
	                if(node.right!=null)
	                    q.add(new Pair(node.right,curr));
	            }
	            
	            return sum;
	        }
	    }

}
