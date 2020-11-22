package com.data.binaryTree;

public class IsSymmetric {
	
	public static void main(String args[]) {
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(2); 
        root.left.left = new Node(3); 
        root.left.right = new Node(4); 
        root.right.left = new Node(4); 
        root.right.right = new Node(3);
        Boolean flag  = isSymmetric(root);
        System.out.println(flag);
	}

	 public static boolean isSymmetric(TreeNode root) {
	        if(root == null)
	            return true;
	        return dfs(root.left,root.right);
	        
	    }
	    
	    private boolean dfs(TreeNode left,TreeNode right){
	        if(left == null && right == null)
	            return true;
	        
	        if(left==null || right == null)
	            return false;
	        
	        if(left.val == right.val){
	            return dfs(left.left,right.right) && dfs(left.right,right.left);
	        }
	        
	        return false;
	    }
}


//efficient code to convert given tree to mirror.