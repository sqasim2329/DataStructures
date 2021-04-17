package com.data.google.microsoft;

public class ClosestBinarySearchTreeValue2 {
	
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
	    
	    public List<Integer> closestKValues(TreeNode root, double target, int k) {
	        
	    	 public List<Integer> closestKValues(TreeNode root, double target, int k) {
	    	        
	    	        List<Integer> ls = new ArrayList<>();
	    	        Stack<TreeNode> stk = new Stack<>();
	    	        while(!stk.isEmpty() || root!=null){
	    	            while(root!=null){
	    	                stk.push(root);
	    	                root = root.left;
	    	            }
	    	            
	    	            root = stk.pop();
	    	            if(ls.size() < k){
	    	                ls.add(root.val);
	    	            }else{
	    	                if(Math.abs(target-root.val) < Math.abs(target - ls.get(0))){
	    	                    ls.remove(0);
	    	                    ls.add(root.val);
	    	                }
	    	            }
	    	            root = root.right;
	    	        }
	    	        return ls;
	    	        
	    	    }
	        
	    }
	}
	
//	O(K)// k is number of nodes from in one side
	public int closestValue(TreeNode root, double target) {
        int val = -1;
        Stack<TreeNode> stk = new Stack<>();
        while(!stk.isEmpty() || root!=null){
            while(root!=null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if(Math.abs(target-val) > Math.abs(target-root.val))
                val = root.val;
            root= root.right;
            
        }
        
        return val;
        
    }
	
//	O(H)
	public int closestValue(TreeNode root, double target) {
        int val = -1;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
            root = stk.pop();
            if(Math.abs(target-val) > Math.abs(target-root.val))
                val = root.val;
            if(target < root.val && root.left!=null)
                stk.push(root.left);
            if(target > root.val && root.right!=null)
                stk.push(root.right);
        }
        
        return val;
        
    }

}
