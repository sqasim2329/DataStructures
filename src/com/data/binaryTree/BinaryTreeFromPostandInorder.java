package com.data.binaryTree;

public class BinaryTreeFromPostandInorder {
	
	int post;
    int in;
    public TreeNode buildTree(int[] inorder, int[] postorder) {    
        post = postorder.length-1;
        in = inorder.length-1;
        return dfs(inorder,postorder,Integer.MIN_VALUE);
    }
    
    private TreeNode dfs(int[] inorder, int[] postorder, int stop){
        if(post < 0)
            return null;
        
        if(inorder[in]==stop){
            in--;
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[post--]);
        root.right = dfs(inorder,postorder,root.val);
        root.left = dfs(inorder,postorder,stop);
        return root;
    }
    
    public static void main(String args[]) {
    	int [] inorder = {9,3,15,20,7};
    			int[] postorder = {9,15,7,20,3};
    	BinaryTreeFromPostandInorder bt = new BinaryTreeFromPostandInorder();
    	bt.buildTree(inorder, postorder);
    }

}
