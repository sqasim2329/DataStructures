package com.data.google.microsoft;
//check for O(1) solution as well
public class RecoverBinaryTree {
	
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
	    public void recoverTree(TreeNode root) {
	        
	        List<Integer> ls = new ArrayList<>();
	        inorder(ls,root);
	        Integer first = null;
	        Integer second = null;
	        for(int i=0;i<ls.size()-1;i++){
	            if(ls.get(i) > ls.get(i+1)){
	                second = ls.get(i+1);
	                if(first == null) first = ls.get(i);    
	                else break;
	                }
	            }
	        inorder(root,first,second,2);
	        }
	            
	    
	    private void inorder(List<Integer> ls, TreeNode root){
	        if(root == null)
	            return ;
	        inorder(ls,root.left);
	        ls.add(root.val);
	        inorder(ls,root.right);
	    }

	    private void inorder(TreeNode root, Integer first, Integer second,int count){
	        if(root == null || count == 0)
	            return ;
	        inorder(root.left,first,second,count);
	        if(root.val == first){
	            root.val = second;
	            count--;
	            }
	        else if(root.val == second){
	            root.val = first;
	            count--;
	        }
	        inorder(root.right,first,second,count);
	    }
	}



	   
	    

}
