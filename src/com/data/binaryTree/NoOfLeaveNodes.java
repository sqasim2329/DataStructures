package com.data.binaryTree;

public class NoOfLeaveNodes {
	
	public static void main(String args[]) {
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(6);
        
        int n = countLeaves(root);
        System.out.println(n);
	}

	private static int countLeaves(Node node) {
		 if(node == null)
	         return 0;
	         
	         if(node.left==null && node.right==null)
	         return 1;
	         
	         return countLeaves(node.left)+countLeaves(node.right);
		
	}

}
