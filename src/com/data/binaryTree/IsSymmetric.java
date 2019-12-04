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
        Boolean flag  = isMirror(root.left,root.right);
        System.out.println(flag);
	}

	private static Boolean isMirror(Node left, Node right) {
		if(left==null && right == null) 
			return true;
		if(left!=null && right!=null && left.data == right.data)
			return isMirror(left.left, right.right) &&
					isMirror(left.right,right.left);
		
		 return false;
	}
}


//efficient code to convert given tree to mirror.