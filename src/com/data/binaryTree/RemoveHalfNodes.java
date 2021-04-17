package com.data.binaryTree;

public class RemoveHalfNodes {
	
	public static Node RemoveHalfNodes(Node root)
    {
        if(root == null)
        return root;
        
        root.left =  RemoveHalfNodes(root.left);
        root.right =  RemoveHalfNodes(root.right);
        
        if(root.left!=null && root.right == null)
        return root.left;
        else if(root.left == null && root.right != null)
        return root.right;
        else
        return root;// will cover both null and both not null
    }

}
