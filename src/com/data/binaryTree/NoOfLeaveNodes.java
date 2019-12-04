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
        
        int n = findCountOfLeafNodes(root);
        System.out.println(n);
	}

	private static int findCountOfLeafNodes(Node root) {
		if(root == null)
		return 0;
		
		int cl = findCountOfLeafNodes(root.left);
		if(root.left==null && root.right == null)
			return 1;
		int cr = findCountOfLeafNodes(root.right);
		return cl+cr;
		
	}

}
