package com.data.binaryTree;

public class BinaryTreeFromPreAndInorder {
	
	 int pre=0;
	    int in=0;
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        return dfs(preorder,inorder,Integer.MIN_VALUE);
	    }
	    
	    private TreeNode dfs(int[] preorder, int[] inorder, int stop){
	        if(pre>=preorder.length){
	            return null;
	        }
	        
	        if(inorder[in] ==  stop){
	            in++;
	            return null;
	        }
	        
	        TreeNode root = new TreeNode(preorder[pre++]);
	        root.left = dfs(preorder,inorder,root.val);
	        root.right = dfs(preorder,inorder,stop);
	        return root;
	    }

}
/****
 * preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
 * 
 * ****/
 