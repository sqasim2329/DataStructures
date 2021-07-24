package com.data.linkedin;

public class InOrderSuccessorBST {
	
	class Solution {
	    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	        TreeNode ans = null;
	        while(root!=null){
	            if(p.val >= root.val){
	                root = root.right;
	            }else{
	                ans = root;
	                root = root.left;   
	            }
	        }
	        return ans;
	            
	        
	    }

}
