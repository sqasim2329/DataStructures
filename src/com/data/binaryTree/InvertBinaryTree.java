package com.data.binaryTree;

public class InvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        
        TreeNode left = invertTree(root.left); 
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
	
public TreeNode invertTree(TreeNode root) {
        
        if(root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            TreeNode right = node.right;
            TreeNode left = node.left;
            if(left!=null)
                q.add(left);
            if(right!=null)
                q.add(right);
            
            node.left = right;
            node.right = left;
            
        }
        return root;
        
    }

}
